package com.echipa11.all4food.model;

import com.echipa11.all4food.util.StatusComanda;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "comandaId")
public class Comanda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comandaId;

    @OneToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPlasarii;

    @NotNull
    private StatusComanda status = StatusComanda.DESCHISA;

    @NotNull
    private Float total = 0F;

    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetaliiComanda> detaliiComenzi;

    public Comanda() {
    }

    public Comanda(Client client, StatusComanda statusComanda) {
        this.client = client;
        this.status = statusComanda;
    }

    public Long getComandaId() {
        return comandaId;
    }

    public void setComandaId(Long comandaId) {
        this.comandaId = comandaId;
    }

    public List<DetaliiComanda> getDetaliiComenzi() {
        return detaliiComenzi;
    }

    public void setDetaliiComenzi(List<DetaliiComanda> detaliiComenzi) {
        this.detaliiComenzi = detaliiComenzi;
    }

    public Long getComanda_id() {
        return comandaId;
    }

    public void setComanda_id(Long comanda_id) {
        this.comandaId = comanda_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDataPlasarii() {
        return dataPlasarii;
    }

    public void setDataPlasarii(Date dataPlasarii) {
        this.dataPlasarii = dataPlasarii;
    }

    public StatusComanda getStatus() {
        return status;
    }

    public void setStatus(StatusComanda status) {
        this.status = status;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
