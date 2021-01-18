package com.example.Inventory.service.impl;

import com.example.Inventory.model.Inventory;
import com.example.Inventory.repository.InventoryRepository;
import com.example.Inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> findByMerchantId(int id) {
        List<Inventory> inventoryList = inventoryRepository.findByMerchantId(id);
        return inventoryList;
    }

    @Override
    public List<Inventory> findByProductIdOrderByQuantityDesc(String productId) {
        return inventoryRepository.findByProductIdOrderByQuantityDesc(productId);
    }

    @Override
    public Inventory findById(int id) {
       return inventoryRepository.findById(id).get();
    }

    @Override
    public List<Inventory> findByProductIdAndMerchantId(String productId, int merchantId) {
        return inventoryRepository.findByProductIdAndMerchantId(productId,merchantId);
    }
}
