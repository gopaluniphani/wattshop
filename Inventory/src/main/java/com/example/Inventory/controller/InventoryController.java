package com.example.Inventory.controller;

import com.example.Inventory.model.Inventory;
import com.example.Inventory.service.impl.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/inventory")
public class InventoryController {

    @Autowired
    InventoryServiceImpl inventoryService;

    @GetMapping(value = "/merchant/{merchantId}")
    public List<Inventory> findByMerchantId(@PathVariable("merchantId") int merchantId) {
        return inventoryService.findByMerchantId(merchantId);
    }

    @PutMapping(value = "/")
    public void update(@RequestBody Inventory inventory) {
        inventoryService.save(inventory);
    }

    @PostMapping(value = "/")
    public Inventory save(@RequestBody Inventory inventory) {
        return inventoryService.save(inventory);
    }

    @GetMapping(value = "/product/{productId}")
    public List<Inventory> findByProductId(@PathVariable("productId") String id) {
        return inventoryService.findByProductId(id);
    }

    @GetMapping(value = "/{inventoryId}")
    public Inventory findByInventoryId(@PathVariable("inventoryId") int id) {
        return inventoryService.findById(id);
    }
}
