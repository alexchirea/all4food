package com.echipa11.all4food.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;

    @NotNull
    @NotBlank(message = "Campul 'Nume' este obligatoriu")
    private String nume;

    @NotNull
    @NotBlank(message = "Campul 'Prenume' este obligatoriu")
    private String prenume;

    @NotNull
    @NotBlank(message = "Campul 'Adresa' este obligatoriu")
    private String adresa;

    @NotNull
    @NotBlank(message = "Campul 'Oras' este obligatoriu")
    private String oras;

    @NotNull
    @NotBlank(message = "Campul 'Telefon' este obligatoriu")
    private String telefon;

    public Client() {
    }

    public Client(String nume, String prenume, String adresa, String oras, String telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.oras = oras;
        this.telefon = telefon;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long client_id) {
        this.clientId = client_id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
