package com.example.ProductsService.service.impl;

import com.example.ProductsService.model.Products;
import com.example.ProductsService.repository.ProductsRepository;
import com.example.ProductsService.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Products save(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public Products findById(String id) {
        return productsRepository.findById(id).get();
    }

    @Override
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Products> findByCategoryId(int id) {
        Iterable<Products> productsIterable = productsRepository.findByCategoryId(id);
        List<Products> productsList = new ArrayList<>();
        productsIterable.forEach(productsList::add);
        return productsList;
    }

    @Override
    public void deleteById(String id) {
        productsRepository.deleteById(id);
    }

    @Override
    public List<Products> findByCategoryIdAndBrandName(int id, String brandName) {
        return productsRepository.findByCategoryIdAndBrandName(id, brandName);
    }

    @Override
    public Products getByProductName(String productName) {
        return productsRepository.getByProductName(productName);
    }

    @Override
    public List<Products> sortByQuery(Query q) {
        return mongoTemplate.find(q, Products.class);
    }
}
