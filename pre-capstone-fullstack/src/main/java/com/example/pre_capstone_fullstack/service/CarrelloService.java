package com.example.pre_capstone_fullstack.service;

import com.example.pre_capstone_fullstack.entity.Carrello;
import com.example.pre_capstone_fullstack.repository.CarrelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrelloService {
    @Autowired
    private CarrelloRepository carrelloRepository;

    public Carrello addToCarrello(Carrello carrello) {
        return carrelloRepository.save(carrello);
    }

    public void removeFromCarrello(Long id) {
        carrelloRepository.deleteById(id);
    }

    public List<Carrello> getUserCarrello(Long userId) {
        return carrelloRepository.findAll();
    }
}
