package com.example.pre_capstone_fullstack.controller;

import com.example.pre_capstone_fullstack.entity.Ordine;
import com.example.pre_capstone_fullstack.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ordini")
public class OrdineController {
    @Autowired
    private OrdineService ordineService;

    @PostMapping
    public ResponseEntity<Ordine> createOrder(@RequestBody Ordine ordine) {
        return ResponseEntity.ok(ordineService.createOrder(ordine));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Ordine>> getUserOrders(@PathVariable Long userId) {
        return ResponseEntity.ok(ordineService.getUserOrders(userId));
    }
}