package com.example.ProductsService.service;

import com.example.ProductsService.model.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    Products save (Products product);
    Products findById (int id);
    List<Products> findAll();
    void deleteById(int id);
}
