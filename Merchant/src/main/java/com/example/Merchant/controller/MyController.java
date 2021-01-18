package com.example.Merchant.controller;

import com.example.Merchant.entity.Merchant;
import com.example.Merchant.entity.Messaging;
import com.example.Merchant.services.MerchantService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/merchant/")
public class MyController {
    @Autowired
    MerchantService merchantService;

    @GetMapping(value="/")
    List<Merchant> findAll(){
        return merchantService.findAll();
    }

    @GetMapping(value="/{id}")
    Merchant getMerchant(@PathVariable("id") int id){
        return merchantService.findById(id);
    }

    @PostMapping(value="/")
    public Merchant save(@RequestBody Merchant merchant){
        return merchantService.save(merchant);
    }

    @PutMapping(value="/")
    public Merchant update(@RequestBody Merchant merchant){
        return merchantService.save(merchant);
    }

    @DeleteMapping(value="/{empId}")
    public void deleteById(@PathVariable("empId") int id){
        merchantService.deleteById((id));
    }

    @GetMapping(value = "/email/{email}")
    public Merchant findByEmail(@PathVariable("email") String email) {
        return merchantService.findByEmail(email);
    }

    @KafkaListener(topics = "updateMerchantRating",groupId = "group_merchant_rating")
    public void consume(@RequestBody String string) {
        Gson gson = new Gson();
        Messaging messaging = gson.fromJson(string,Messaging.class);
        Merchant merchant = merchantService.findById(messaging.getMerchantId());
        merchant.setRating(messaging.getRating());
        merchantService.save(merchant);
    }
}
