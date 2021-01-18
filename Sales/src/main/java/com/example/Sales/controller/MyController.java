package com.example.Sales.controller;
//
import com.example.Sales.entity.Messaging;
import com.example.Sales.entity.Sales;
import com.example.Sales.services.SalesService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sales")
public class MyController {
    @Autowired
    SalesService salesService;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping(value = "/")
    List<Sales> findAll() {
        return salesService.findAll();
    }

    @GetMapping(value = "/user/{userId}")
    List<Sales> findById(@PathVariable("userId") String userId) {
        return salesService.findByUserId(userId);
    }

    @PostMapping(value = "/")
    public Sales save(@RequestBody Sales sales) {
        Messaging messaging = new Messaging();
        messaging.setMerchantId(sales.getMerchantId());
        messaging.setProductId(sales.getProductId());
        messaging.setQuantity(sales.getQuantity());
        String string = new Gson().toJson(messaging);
        kafkaTemplate.send("updateQuantity", "key", string);
        return salesService.save(sales);
    }

    @PostMapping(value = "/salesList")
    public void saveList(@RequestBody List<Sales> salesList) {
        for(Sales item : salesList) {
            salesService.save(item);
        }
    }

    @PutMapping(value = "/")
    public Sales update(@RequestBody Sales sales) throws Exception {

        float rating = sales.getRating();
        int i = 0;
        Messaging messaging = new Messaging();
        List<Sales> salesListByProduct= salesService.findByProductId(sales.getProductId());
        for (Sales item: salesListByProduct) {
            rating+=item.getRating();
            i++;
        }
        float productRating = rating/i;
        messaging.setMerchantId(sales.getMerchantId());
        messaging.setProductId(sales.getProductId());
        messaging.setRating(productRating);
        String string = new Gson().toJson(messaging);
        kafkaTemplate.send("updateProductRating",string);

        List<Sales> salesListByMerchant = salesService.findByMerchantId(sales.getMerchantId());
        rating = sales.getRating();
        i=0;
        for(Sales item: salesListByMerchant) {
            rating+=item.getRating();
            i++;
        }
        float merchantRating = rating/i;
        messaging.setRating(merchantRating);
        string = new Gson().toJson(messaging);
        kafkaTemplate.send("updateMerchantRating",string);

        return salesService.save(sales);
    }

    @GetMapping(value = "/merchant/{merchantId}")
    List<Sales> displayMerchantDetails(@PathVariable("merchantId") int merchantId) {
        return salesService.findByMerchantId(merchantId);
    }
}
