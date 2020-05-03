package com.echipa11.all4food.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class DetaliiComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long detaliiComandaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comanda_id", referencedColumnName = "comandaId", nullable = false)
    Comanda comanda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produs_id", referencedColumnName = "produsId", nullable = false)
    Produs produs;

    String numeProdus;

    @NotNull
    float pret;

    @NotNull
    int cantitate;

    @NotNull
    float pretTotal;

    public DetaliiComanda() {
    }

    public Long getDetaliiComandaId() {
        return detaliiComandaId;
    }

    public void setDetaliiComandaId(Long detaliiComandaId) {
        this.detaliiComandaId = detaliiComandaId;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public float getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(float pretTotal) {
        this.pretTotal = pretTotal;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }
}
