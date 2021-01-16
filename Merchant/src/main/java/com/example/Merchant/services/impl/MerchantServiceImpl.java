package com.example.Merchant.services.impl;

import com.example.Merchant.entity.Merchant;
import com.example.Merchant.repository.MerchantRepository;
import com.example.Merchant.services.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant findById(int merchantId) {
        return merchantRepository.findById(merchantId).get();
    }

    @Override
    public void deleteById(int merchantId) {
        merchantRepository.deleteById(merchantId);
    }

    @Override
    public List<Merchant> findAll() {
        Iterable<Merchant> merchantIterable=merchantRepository.findAll();
        List<Merchant> merchantList=new ArrayList<>();
        merchantIterable.forEach(merchantList::add);
        return merchantList;
    }

    @Override
    public Merchant findByEmail(String email) {
        return merchantRepository.findByEmail(email);
    }
}
