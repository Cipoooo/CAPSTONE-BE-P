package com.example.pre_capstone_fullstack.repository;

import com.example.pre_capstone_fullstack.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente,Long> {
    Utente findByEmail(String email);
}
