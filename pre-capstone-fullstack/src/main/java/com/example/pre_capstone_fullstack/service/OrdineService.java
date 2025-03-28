package com.example.pre_capstone_fullstack.service;

import com.example.pre_capstone_fullstack.entity.Ordine;
import com.example.pre_capstone_fullstack.repository.OrdineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdineService {
    @Autowired
    private OrdineRepository ordineRepository;

    public Ordine createOrder(Ordine ordine) {
        return ordineRepository.save(ordine);
    }

    public List<Ordine> getUserOrders(Long userId) {
        return ordineRepository.findAll();
    }
}
