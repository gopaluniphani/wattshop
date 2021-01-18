package com.example.Inventory.controller;

import com.example.Inventory.model.Cart;
import com.example.Inventory.model.Inventory;
import com.example.Inventory.model.Messaging;
import com.example.Inventory.service.impl.InventoryServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.ArrayList;
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
        return inventoryService.findByProductIdOrderByQuantityDesc(id);
    }

    @GetMapping(value = "/{inventoryId}")
    public Inventory findByInventoryId(@PathVariable("inventoryId") int id) {
        return inventoryService.findById(id);
    }

    @GetMapping(value = "/cart")
    public List<Inventory> findCartDetails(@RequestBody List<Cart> cartList ) {
        List<Inventory> inventoryList = new ArrayList<>();
        for(Cart item:cartList) {
            Inventory inventoryItem = inventoryService.findById(item.getInventoryId());
            inventoryList.add(inventoryItem);
        }
        return inventoryList;

    }

    @KafkaListener(topics = "updateQuantity",groupId = "group_quantity")
    public void consume(@RequestBody String string) {
        Gson gson = new Gson();
        Messaging messaging = gson.fromJson(string,Messaging.class);
        List<Inventory> inventoryList=inventoryService.findByProductIdAndMerchantId(messaging.getProductId(),messaging.getMerchantId());
        Inventory inventory = inventoryList.get(0);
        inventory.setQuantity(inventory.getQuantity()-messaging.getQuantity());
        inventoryService.save(inventory);
    }
}
