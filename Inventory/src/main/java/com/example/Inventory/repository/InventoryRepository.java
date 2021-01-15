package com.example.Inventory.repository;

import com.example.Inventory.model.IdPK;
import com.example.Inventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,IdPK> {
    List<Inventory> findByIdPKMerchantId(String id);
    List<Inventory> findByIdPKProductId(int productId);
}
