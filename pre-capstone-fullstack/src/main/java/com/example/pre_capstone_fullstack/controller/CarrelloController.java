package com.example.pre_capstone_fullstack.controller;

import com.example.pre_capstone_fullstack.entity.Carrello;
import com.example.pre_capstone_fullstack.service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrello")
public class CarrelloController {
    @Autowired
    private CarrelloService carrelloService;

    @PostMapping
    public ResponseEntity<Carrello> addToCarrello(@RequestBody Carrello carrello) {
        return ResponseEntity.ok(carrelloService.addToCarrello(carrello));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Carrello>> getUserCarrello(@PathVariable Long userId) {
        return ResponseEntity.ok(carrelloService.getUserCarrello(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFromCarrello(@PathVariable Long id) {
        carrelloService.removeFromCarrello(id);
        return ResponseEntity.noContent().build();
    }
}
