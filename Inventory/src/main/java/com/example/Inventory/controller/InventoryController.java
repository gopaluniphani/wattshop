package com.example.Inventory.controller;

import com.example.Inventory.model.Inventory;
import com.example.Inventory.service.impl.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class InventoryController {
    @Autowired

    InventoryServiceImpl inventoryService;

    @GetMapping(value = "/merchant/display/{merchantId}")
    public List<Inventory> findByMerchantId(@PathVariable("id") String merchantId) {
        return inventoryService.findByMerchantId(merchantId);
    }

    @PutMapping(value = "/merchant/update")
    public void update(@RequestBody Inventory inventory) {
        inventoryService.save(inventory);
    }

    @PostMapping(value = "/merchant/save")
    public void save(Inventory inventory) {
        inventoryService.save(inventory);
    }

    @GetMapping(value = "/user/display/{productId}")
    public List<Inventory> findByProductId(@PathVariable("productId") int id) {
        return inventoryService.findByProductId(id);
    }

}
