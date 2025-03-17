package com.example.pre_capstone_fullstack.entity;

import jakarta.persistence.*;
//import jakarta.validation.constraints.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class videogioco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotBlank
    private String titolo;

    //@NotBlank
    private String piattaforma; // PS5, Xbox, PC, Switch

    //@DecimalMin("0.01")
    private Double prezzo;

    //@NotBlank
    private String genere; // Azione, RPG, Sport

    private String dataUscita; // Stringa o LocalDate

    //@NotBlank
    private String copertinaUrl;// URL dell'immagine salvata

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getDataUscita() {
        return dataUscita;
    }

    public void setDataUscita(String dataUscita) {
        this.dataUscita = dataUscita;
    }

    public String getCopertinaUrl() {
        return copertinaUrl;
    }

    public void setCopertinaUrl(String copertinaUrl) {
        this.copertinaUrl = copertinaUrl;
    }
}
