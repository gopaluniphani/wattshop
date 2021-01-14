package com.example.ProductsService.repository;

import com.example.ProductsService.model.Products;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends CrudRepository <Products,Integer>{
}
