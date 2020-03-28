package com.echipa11.all4food.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produsId;

    @NotNull
    @NotBlank(message = "Campul 'denumire' este obligatoriu")
    private String denumire;

    @NotNull
    @NotBlank(message = "Campul 'descriere' este obligatoriu")
    private String descriere;

    @NotNull
    @NotBlank(message = "Campul 'pret' este obligatoriu")
    private float pret;

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