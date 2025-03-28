package com.example.pre_capstone_fullstack.service;

import com.example.pre_capstone_fullstack.entity.Utente;
import com.example.pre_capstone_fullstack.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public Utente registraUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Optional<Utente> login(String email, String password) {
        Utente utente = utenteRepository.findByEmail(email);
        return (utente != null && utente.getPassword().equals(password)) ? Optional.of(utente) : Optional.empty();
    }
    public List<Utente> getAllUsers() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUserById(Long id) {
        return utenteRepository.findById(id);
    }

    public void deleteUser(Long id) {
        utenteRepository.deleteById(id);
    }
}

