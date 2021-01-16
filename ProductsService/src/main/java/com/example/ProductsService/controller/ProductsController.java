package com.example.ProductsService.controller;

import com.example.ProductsService.model.Products;
import com.example.ProductsService.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    //to send the list of products to user homepage
    @GetMapping(value = "/")
    public List<Products> findAll() {
        return productsService.findAll();
    }

    //to send the details of a single product when the user needs to check a specific item
    @GetMapping(value = "/{productId}")
    public Products findById(@PathVariable("productId") String id) {
        return productsService.findById(id);
    }

    //to save the product details of a new product entered by the merchant
    @PostMapping(value = "/")
    public Products save(@RequestBody Products product) {
        return productsService.save(product);
    }

    //to find all the products in a particular id
    @GetMapping(value = "/category/{categoryId}")
    public List<Products> findByCategoryId(@PathVariable("categoryId") int id) {
        return productsService.findByCategoryId(id);
    }

    //to get all the brand names selling a product of particular category
    @GetMapping(value = "/getbrandname/{categoryId}")
    public Set<String> getBrandName(@PathVariable("categoryId") int id) {
        List<Products> productsList = productsService.findByCategoryId(id);
        Set<String> brandNames = new HashSet<>();
        for (Products product : productsList) {
            brandNames.add(product.getBrandName());
        }
        return brandNames;
    }

    //to get the products names for all the items sold in a particular category of a particular brand
    @GetMapping(value = "/{categoryId}/{brandName}")
    public List<String> getProductNames(@PathVariable("categoryId") int id, @PathVariable("brandName") String brandName) {
        List<Products> productsList = productsService.findByCategoryIdAndBrandName(id, brandName);
        List<String> productNames = new ArrayList<>();
        for (Products product : productsList) {
            productNames.add(product.getProductName());
        }
        return productNames;
    }
}
