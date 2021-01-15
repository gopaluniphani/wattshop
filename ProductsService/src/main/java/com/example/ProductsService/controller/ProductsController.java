package com.example.ProductsService.controller;

import com.example.ProductsService.model.Products;
import com.example.ProductsService.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    //to send the list of products to user homepage
    @GetMapping(value = "/findAll")
    public List<Products> findAll() {
        List<Products> productsList =  productsService.findAll();
        return productsList;
    }

    //to send the details of a single product when the user needs to check a specific item
    @GetMapping(value = "/find/{productId}")
    public Products findById(@PathVariable("productId") int id) {
        Products product = productsService.findById(id);
        return product;
    }

    //to save the product details of a new product entered by the merchant
    @PostMapping(value = "/save")
    public Products save(@RequestBody Products product) {
        return productsService.save(product);
    }

    //to find all the products in a particular id
    @GetMapping(value = "/category/{categoryId}")
    public List<Products> findByCategoryId(@PathVariable("categoryId")int id) {
        List<Products> productsList =  productsService.findByCategoryId(id);
        return productsList;
    }

    //to get all the brand names selling a product of particular category
    @GetMapping(value = "/add/getBrandName/{categoryId}")
    public List<String> getBrandName(@PathVariable("categoryId")int id) {
        List<Products> productsList = productsService.findByCategoryId(id);
        List<String> brandNames = new ArrayList<>();
        for (Products product:productsList) {
            if (!brandNames.contains(product.getBrandName())) {
                brandNames.add(product.getBrandName());

            }
        }
        return brandNames;
    }

    //to get the products names for all the items sold in a particular category of a particular brand
    @GetMapping(value = "/add/getBrandName/{categoryId}/{brandName}")
    public List<String> getProductName(@PathVariable("categoryId") int id, @PathVariable("brandName")String brandName) {
        List<Products> productsList = productsService.findByCategoryIdAndBrandName(id,brandName);
        List<String> productNames = new ArrayList<>();
        for (Products product:productsList) {
            productNames.add(product.getProductName());
        }
        return productNames;
    }

    //to get the product id of a particular product
    @GetMapping(value = "getProductId/{productName}")
    public int getProductId(@PathVariable("productName") String productName) {
        Products product = productsService.getByProductName(productName);
        int productId = product.getProductId();
        return productId;
    }
}
