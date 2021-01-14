package com.example.Sales.services;

import com.example.Sales.entity.Sales;

import java.util.List;

public interface SalesService {
    Sales save(Sales sales);
    Sales findById(int id);
    void deleteById(int id);
    List<Sales> findAll();
    List<Sales> findByMerchantid(int merchantId);
}
