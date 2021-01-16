package com.example.Inventory.service;

import com.example.Inventory.model.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    Inventory save (Inventory inventory);
    List<Inventory> findByMerchantId (int id);
    List<Inventory> findByProductId(String productId);
    Inventory findById(int id);
}
