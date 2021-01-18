package com.example.elasticsearch.controller;
import com.example.elasticsearch.entity.Product;
import com.example.elasticsearch.entity.Specification;
import com.example.elasticsearch.services.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/elastic")
public class MyController {
    @Autowired
    ElasticSearchService elasticSearchService;

    @PostMapping(value="/save")
    public Product save(@RequestBody Product product){
        List<Specification> specs=product.getSpecificationList();
        String temp="";
        for (Specification spe:specs) {
            temp+=spe.getKey()+" "+spe.getValue()+" ";
        }
        product.setSpecificationString(temp);
        System.out.println(temp);
        return elasticSearchService.save(product);
    }

    @GetMapping(value="/findall")
    List<Product> findAll(){
        return elasticSearchService.findAll();
    }

    @GetMapping(value="/search/{searchTerm}")
    public List<Product> search(@PathVariable("searchTerm") String search){
        return elasticSearchService.processSearch(search);
    }
}
