package com.example.pre_capstone_fullstack.controller;

import com.example.pre_capstone_fullstack.entity.Ordine;
import com.example.pre_capstone_fullstack.service.PagamentoService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamenti")
@RequiredArgsConstructor
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody List<String> items, @RequestParam double totale) {
        try {
            String checkoutUrl = pagamentoService.createCheckoutSession(items, totale);
            return ResponseEntity.ok(checkoutUrl);
        } catch (StripeException e) {
            return ResponseEntity.badRequest().body("Errore nel pagamento: " + e.getMessage());
        }
    }
}
