package com.example.Merchant.services;

import com.example.Merchant.entity.Merchant;

import java.util.List;

public interface MerchantService {
    Merchant save(Merchant merchant);
    Merchant findById(int merchantId);
    void deleteById(int merchantId);
    List<Merchant> findAll();
}
