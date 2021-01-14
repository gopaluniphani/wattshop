package com.example.Sales.services.impl;

import com.example.Sales.entity.Sales;
import com.example.Sales.repository.SalesRepository;
import com.example.Sales.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    SalesRepository salesRepository;

    @Override
    public Sales save(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public Sales findById(int id) {
        return salesRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        salesRepository.deleteById(id);
    }

    @Override
    public List<Sales> findAll() {
        Iterable<Sales> salesIterable=salesRepository.findAll();
        List<Sales> salesList=new ArrayList<>();
        salesIterable.forEach((salesList::add));
        return salesList;
    }

    @Override
    public List<Sales> findByMerchantid(int merchantId) {
        Iterable<Sales> salesIterable=salesRepository.findByMerchantId(merchantId);
        List<Sales> salesList=new ArrayList<>();
        salesIterable.forEach((salesList::add));
        return salesList;
    }
}
