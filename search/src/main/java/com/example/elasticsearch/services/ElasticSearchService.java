package com.example.elasticsearch.services;

import com.example.elasticsearch.entity.Product;

import java.util.List;

public interface ElasticSearchService {
    Product save(Product product);
    List<Product> findAll();
    Product findById(String id);
    void deleteAll();
    List<Product> processSearch(String query);
}
