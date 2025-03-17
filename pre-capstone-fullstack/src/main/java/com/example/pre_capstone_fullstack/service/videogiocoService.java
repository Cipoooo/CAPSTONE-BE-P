package com.example.pre_capstone_fullstack.service;

import com.example.pre_capstone_fullstack.entity.videogioco;
import com.example.pre_capstone_fullstack.repository.videogiocoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class videogiocoService {

    private final JdbcTemplate jdbcTemplate; // Questo è il tuo JdbcTemplate

    @Autowired
    public videogiocoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    videogiocoRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    public void salvaVideogiochi(List<videogioco> videogiochi) {
        for (videogioco vg : videogiochi) {
            String nuovaCopertinaUrl = scaricaImmagine(vg.getCopertinaUrl());
            vg.setCopertinaUrl(nuovaCopertinaUrl);
            repository.save(vg);  // Salva ogni videogioco nella lista
        }
    }
    
    public List<videogioco> ottieniTutti() {
        return repository.findAll();
    }

    public Optional<videogioco> ottieniPerId(Long id) {
        return repository.findById(id);
    }

    public Optional<videogioco> aggiornaVideogioco(Long id, videogioco nuovoVideogioco) {
        return repository.findById(id).map(videogioco -> {
            videogioco.setTitolo(nuovoVideogioco.getTitolo());
            videogioco.setPiattaforma(nuovoVideogioco.getPiattaforma());
            videogioco.setPrezzo(nuovoVideogioco.getPrezzo());
            videogioco.setGenere(nuovoVideogioco.getGenere());
            videogioco.setDataUscita(nuovoVideogioco.getDataUscita());

            // Se la copertina cambia, scarichiamo la nuova immagine
            if (!videogioco.getCopertinaUrl().equals(nuovoVideogioco.getCopertinaUrl())) {
                String nuovaCopertinaUrl = scaricaImmagine(nuovoVideogioco.getCopertinaUrl());
                videogioco.setCopertinaUrl(nuovaCopertinaUrl);
            }

            return repository.save(videogioco);
        });
    }

    public boolean eliminaVideogioco(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public void eliminaTuttiVideogiochi() {
        repository.deleteAll();

        jdbcTemplate.execute("ALTER SEQUENCE videogioco_id_seq RESTART WITH 1;");
    }

    private String scaricaImmagine(String imageUrl) {
        try {
            byte[] imageBytes = restTemplate.getForObject(imageUrl, byte[].class);
            String fileName = "covers/" + System.currentTimeMillis() + ".jpg";
            Path path = Paths.get("src/main/resources/static/" + fileName);
            Files.write(path, imageBytes);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return imageUrl; // Se fallisce, mantiene il link originale
        }
    }
}