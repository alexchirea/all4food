package com.echipa11.all4food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produsId;

    @NotNull
    @NotBlank(message = "Campul 'denumire' este obligatoriu")
    private String denumire;

    private String descriere;

    private float pret;

    @OneToMany(mappedBy = "produs", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<DetaliiComanda> detaliiComenzi;

    public List<DetaliiComanda> getDetaliiComenzi() {
        return detaliiComenzi;
    }

    public void setDetaliiComenzi(List<DetaliiComanda> detaliiComenzi) {
        this.detaliiComenzi = detaliiComenzi;
    }

    public Produs() {
    }

    public Produs(String d, float p) {
        denumire = d;
        pret = p;
    }

    public Long getProdusId() {
        return produsId;
    }

    public void setProdusId(Long produsId) {
        this.produsId = produsId;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }
}