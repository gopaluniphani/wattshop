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
    public Merchant findById(int id) {
        return merchantRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        merchantRepository.deleteById(id);
    }

    @Override
    public List<Merchant> findAll() {
        Iterable<Merchant> merchantIterable=merchantRepository.findAll();
        List<Merchant> merchantList=new ArrayList<>();
        merchantIterable.forEach(merchantList::add);
        return merchantList;
    }
}
