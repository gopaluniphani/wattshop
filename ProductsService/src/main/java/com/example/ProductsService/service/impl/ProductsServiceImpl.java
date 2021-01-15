package com.example.ProductsService.service.impl;

import com.example.ProductsService.model.Products;
import com.example.ProductsService.repository.ProductsRepository;
import com.example.ProductsService.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public Products save(Products product) {
        return productsRepository.save(product);
    }

    @Override
    public Products findById(int id) {
        return productsRepository.findById(id).get();
    }

    @Override
    public List<Products> findAll() {
        List<Products> productsList = (List<Products>) productsRepository.findAll();
        return productsList;
    }

    @Override
    public void deleteById(int id) {
        productsRepository.deleteById(id);
    }
}
