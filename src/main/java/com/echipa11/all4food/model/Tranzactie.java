package com.echipa11.all4food.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tranzactie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tranzactieId;

    @NotNull
    @NotBlank(message = "Campul 'comandaId' este obligatoriu")
    private Long comandaId;

    @NotNull
    @NotBlank(message = "Campul 'mod_plata' este obligatoriu")
    private String mod_plata;

    @NotNull
    @NotBlank(message = "Campul 'data' este obligatoriu")
    private Date data;

    @NotNull
    @NotBlank(message = "Campul 'suma' este obligatoriu")
    private Float suma;

    @NotNull
    @NotBlank(message = "Campul 'rest' este obligatoriu")
    private Float rest;

    public Long getTranzactieId() {
        return tranzactieId;
    }

    public void setTranzactieId(Long tranzactieId) {
        this.tranzactieId = tranzactieId;
    }

    public Long getComandaId() {
        return comandaId;
    }

    public void setComandaId(Long comandaId) {
        this.comandaId = comandaId;
    }

    public String getMod_plata() {
        return mod_plata;
    }

    public void setMod_plata(String mod_plata) {
        this.mod_plata = mod_plata;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getSuma() {
        return suma;
    }

    public void setSuma(Float suma) {
        this.suma = suma;
    }

    public Float getRest() {
        return rest;
    }

    public void setRest(Float rest) {
        this.rest = rest;
    }
}