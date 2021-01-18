package com.example.Inventory.repository;

import com.example.Inventory.model.Inventory;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,Integer> {
    List<Inventory> findByMerchantId(int merchantId);
    List<Inventory> findByProductId(String productId);
    List<Inventory> findByProductIdOrderByQuantityDesc(String productId);
    List<Inventory> findByProductIdAndMerchantId(String productId, int merchantId);
}
