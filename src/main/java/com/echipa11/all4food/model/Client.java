package com.echipa11.all4food.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long client_id;

    @NotNull
    private String nume;

    @NotNull
    private String prenume;

    @NotNull
    private String adresa;

    @NotNull
    private String oras;

    @NotNull
    private String telefon;

    @OneToMany
    Set comenzi = new HashSet<Comanda>();

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
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

    public Set getComenzi() {
        return comenzi;
    }

    public void setComenzi(Set comenzi) {
        this.comenzi = comenzi;
    }
}
