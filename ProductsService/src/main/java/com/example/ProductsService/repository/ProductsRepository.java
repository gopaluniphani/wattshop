package com.example.ProductsService.repository;

import com.example.ProductsService.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String> {
    List<Products> findByCategoryId(int id);
    List<Products> findByCategoryIdAndBrandName(int id, String brandName);
    Products getByProductName(String productName);
}
