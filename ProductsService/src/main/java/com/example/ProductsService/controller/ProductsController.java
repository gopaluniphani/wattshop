package com.example.ProductsService.controller;

import com.example.ProductsService.model.Products;
import com.example.ProductsService.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping(value = "/findAll")
    public List<Products> findAll() {
        return productsService.findAll();
    }

    @GetMapping(value = "/find/{productId}")
    public Products findById(@PathVariable("id") int id) {
        return productsService.findById(id);
    }

    @PostMapping(value = "/save")
    public void save(Products product) {
        productsService.save(product);
    }
}
