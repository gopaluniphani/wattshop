package com.example.ProductsService.repository;

import com.example.ProductsService.model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository <Products,Integer>{
    List<Products> findByCategoryId(int id);
    List<Products> findByCategoryIdAndBrandName(int id, String brandName);
    Products getByProductName(String productName);
}
