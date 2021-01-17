package com.example.Sales.services;

import com.example.Sales.entity.RatingKafka;
import com.example.Sales.entity.Sales;

import java.util.List;

public interface SalesService {
    Sales save(Sales sales);

    Sales findById(int id);

    void deleteById(int id);

    List<Sales> findAll();

    List<Sales> findByMerchantId(int merchantId);

    List<Sales> findByUserId(String userId);

    List<Sales> findByProductId(String productId);

    String postKafka(RatingKafka ratingKafka) throws Exception;
}
