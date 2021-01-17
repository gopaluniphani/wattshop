package com.example.Sales.repository;

import com.example.Sales.entity.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends CrudRepository<Sales, Integer> {
    List<Sales> findByMerchantId(int merchantId);

    List<Sales> findByUserId(String userId);

    List<Sales> findByProductId(String productId);
}
