package com.example.ProductsService.controller;

import com.example.ProductsService.model.Products;
//import com.example.ProductsService.model.RatingKafka;
import com.example.ProductsService.service.ProductsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
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
        Query query = new Query();
        query.with(Sort.by(new Sort.Order(Sort.Direction.DESC, "rating")));
        return productsService.sortByQuery(query);
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
    public List<Products> getBrandName(@PathVariable("categoryId") int id) {
//        List<Products> productsList = productsService.findByCategoryId(id);
//        Set<String> brandNames = new HashSet<>();
//        for (Products product : productsList) {
//            brandNames.add(product.getBrandName());
//        }
//        return brandNames;
        return productsService.findByCategoryId(id);
    }

    //to get the products names for all the items sold in a particular category of a particular brand
    @GetMapping(value = "/{categoryId}/{brandName}")
    public List<Products> getProductNames(@PathVariable("categoryId") int id, @PathVariable("brandName") String brandName) {
//        List<Products> productsList = productsService.findByCategoryIdAndBrandName(id, brandName);
//        List<String> productNames = new ArrayList<>();
//        for (Products product : productsList) {
//            productNames.add(product.getProductName());
//        }
//        return productNames;
        return productsService.findByCategoryIdAndBrandName(id,brandName);
    }

//    @KafkaListener(topics = {"productRating"})
//    public void getTopics(@RequestBody String string)throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        RatingKafka productRating = objectMapper.readValue(string,RatingKafka.class);
//        Products products = productsService.findById(productRating.getProductId());
//        products.setRating(productRating.getRating());
//        productsService.save(products);
// }
}
