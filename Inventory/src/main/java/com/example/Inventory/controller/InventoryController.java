package com.example.Inventory.controller;

import com.example.Inventory.model.IdPK;
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

    @GetMapping(value = "display/{merchantId}")
    public List<Inventory> findByMerchantId(@PathVariable("id") String merchantId) {
        return inventoryService.findByMerchantId(merchantId);
    }

    @PutMapping(value = "/update/{IdPK}")
    public void update(@PathVariable(value = "IdPK")IdPK idPK, @RequestBody Inventory inventory) {
        inventoryService.save(inventory);
    }

    @PostMapping(value = "/save")
    public void save(Inventory inventory) {
        inventoryService.save(inventory);
    }
}
