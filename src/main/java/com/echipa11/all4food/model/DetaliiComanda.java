package com.echipa11.all4food.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class DetaliiComanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long detaliiComandaId;

    @ManyToOne
    @MapsId("comanda_id")
    @JoinColumn(name = "comandaId")
    Comanda comanda;

    @ManyToOne
    @MapsId("produs_id")
    @JoinColumn(name = "produsId")
    Produs produs;

    @NotNull
    @NotBlank(message = "Campul 'Pret' este obligatoriu")
    float pret;

    @NotNull
    @NotBlank(message = "Campul 'Cantitate' este obligatoriu")
    int cantitate;

    @NotNull
    @NotBlank(message = "Campul 'Pret Total' este obligatoriu")
    float pretTotal;

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

}
