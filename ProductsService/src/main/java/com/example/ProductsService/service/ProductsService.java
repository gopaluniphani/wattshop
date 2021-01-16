package com.example.ProductsService.service;

import com.example.ProductsService.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    Products save (Products product);
    Products findById (String id);
    List<Products> findAll();
    List<Products> findByCategoryId(int id);
    void deleteById(String id);
    List<Products> findByCategoryIdAndBrandName(int id, String brandName);
    Products getByProductName(String productName);
}
