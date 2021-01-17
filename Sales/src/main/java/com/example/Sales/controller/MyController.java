package com.example.Sales.controller;


import com.example.Sales.entity.RatingKafka;
import com.example.Sales.entity.Sales;
import com.example.Sales.services.SalesService;
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

    @GetMapping(value = "/user/{id}")
    List<Sales> findById(@PathVariable("id") String id) {
        return salesService.findByUserId(id);
    }

    @PostMapping(value = "/")
    public Sales save(@RequestBody Sales sales) {
        return salesService.save(sales);
    }

    @PutMapping(value = "/")
    public Sales update(@RequestBody Sales sales) throws Exception {

        float rating = sales.getRating();
        int i = 1;

        List<Sales> salesListByProduct= salesService.findByProductId(sales.getProductId());
        for (Sales item: salesListByProduct) {
            rating+=item.getRating();
            i++;
        }
        RatingKafka productRatingKafka = new RatingKafka();
        productRatingKafka.setMerchantId(0);
        String productKafka = salesService.postKafka(productRatingKafka);
        kafkaTemplate.send("productRating",productKafka);

        List<Sales> salesListByMerchant = salesService.findByMerchantId(sales.getMerchantId());
        rating = sales.getRating();
        i=1;
        for(Sales item: salesListByMerchant) {
            rating+=item.getRating();
            i++;
        }
        RatingKafka merchantRatingKafka = new RatingKafka();
        merchantRatingKafka.setProductId("");
        String merchantKafka = salesService.postKafka(merchantRatingKafka);
        kafkaTemplate.send("merchantRating",merchantKafka);

        return salesService.save(sales);
    }

    @GetMapping(value = "/merchant/{id}")
    List<Sales> displayMerchantDetails(@PathVariable("id") int id) {
        return salesService.findByMerchantId(id);
    }
}
