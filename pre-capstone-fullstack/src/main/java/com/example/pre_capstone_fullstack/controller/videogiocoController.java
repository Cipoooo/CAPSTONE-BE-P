package com.example.pre_capstone_fullstack.controller;

import com.example.pre_capstone_fullstack.entity.videogioco;
import com.example.pre_capstone_fullstack.service.videogiocoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videogiochi")
@RequiredArgsConstructor
public class videogiocoController {

    @Autowired
    videogiocoService service;

    @PostMapping
    public ResponseEntity<String> aggiungiVideogiochi(@RequestBody List<videogioco> videogiochi) {
        try {
            service.salvaVideogiochi(videogiochi);  // Salva tutti i videogiochi nella lista
            return ResponseEntity.ok("Videogiochi aggiunti correttamente!");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Errore nell'aggiungere i videogiochi: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<videogioco>> ottieniTutti() {
        return ResponseEntity.ok(service.ottieniTutti());
    }

    @GetMapping("/{id}")
    public ResponseEntity<videogioco> ottieniPerId(@PathVariable Long id) {
        return service.ottieniPerId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<videogioco> aggiornaVideogioco(@PathVariable Long id, @RequestBody videogioco videogioco) {
        return service.aggiornaVideogioco(id, videogioco)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaVideogioco(@PathVariable Long id) {
        if (service.eliminaVideogioco(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminaTuttiVideogiochi() {
        service.eliminaTuttiVideogiochi();
        return ResponseEntity.noContent().build();
    }
}
