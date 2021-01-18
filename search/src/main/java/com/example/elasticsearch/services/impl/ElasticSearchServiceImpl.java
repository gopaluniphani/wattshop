package com.example.elasticsearch.services.impl;

import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.repository.ElasticRepository;
import com.example.elasticsearch.services.ElasticSearchService;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {
    @Autowired
    ElasticRepository elasticRepository;
    private static final String PRODUCT_INDEX="product";

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public Product save(Product product) {
        return elasticRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        Iterable<Product> productIterable=elasticRepository.findAll();
        List<Product> productList = new ArrayList<>();
        productIterable.forEach(productList::add);
        return productList;
    }

    @Override
    public void deleteAll() {
        elasticRepository.deleteAll();
    }

    @Override
    public Product findById(String id) {
        return elasticRepository.findById(id).get();
    }

    @Override
    public List<Product> processSearch(String query){
        QueryBuilder queryBuilder=
                QueryBuilders
                .multiMatchQuery(query,"productName","productDescription","brandName","specificationString")
                .fuzziness(Fuzziness.AUTO);

        Query searchQuery=new NativeSearchQueryBuilder()
                .withFilter(queryBuilder)
                .build();

        SearchHits<Product> productHits=
                elasticsearchOperations
                .search(searchQuery,Product.class,
                IndexCoordinates.of(PRODUCT_INDEX));

        List<Product> productMatches=new ArrayList<Product>();
        productHits.forEach(searchHit -> {
            productMatches.add(searchHit.getContent());
        });
        return productMatches;
    }
}
