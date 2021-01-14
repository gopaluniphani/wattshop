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
    public List<Inventory> findByMerchantId(String id) {
        List<Inventory> inventoryList = inventoryRepository.findByMerchantId(id);
        return inventoryList;
    }
}
