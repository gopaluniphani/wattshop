package com.example.Merchant.controller;

import com.example.Merchant.entity.Merchant;
import com.example.Merchant.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
