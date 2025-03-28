package com.example.pre_capstone_fullstack.controller;

import com.example.pre_capstone_fullstack.entity.Utente;
import com.example.pre_capstone_fullstack.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @PostMapping("/register")
    public ResponseEntity<Utente> register(@RequestBody Utente utente) {
        return ResponseEntity.ok(utenteService.registraUtente(utente));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        Optional<Utente> utente = utenteService.login(email, password);
        return utente.isPresent() ? ResponseEntity.ok("Login effettuato con successo!") : ResponseEntity.badRequest().body("Email o password errati!");
    }
    @GetMapping
    public ResponseEntity<List<Utente>> getAllUsers() {
        return ResponseEntity.ok(utenteService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        utenteService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
