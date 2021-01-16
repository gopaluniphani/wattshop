package com.example.Sales.controller;


import com.example.Sales.entity.Sales;
import com.example.Sales.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sales")
public class MyController {
    @Autowired
    SalesService salesService;

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
    public Sales update(@RequestBody Sales sales) {
        return salesService.save(sales);
    }

    @GetMapping(value = "/merchant/{id}")
    List<Sales> displayMerchantDetails(@PathVariable("id") int id) {
        return salesService.findByMerchantId(id);
    }
}
