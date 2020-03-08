package com.echipa11.all4food.model;

import com.echipa11.all4food.util.StatusComanda;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long comandaId;

    @OneToOne
    @JoinColumn(name = "clientId")
    private Client client;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_plasarii;

    @NotNull
    @NotBlank(message = "Campul 'Status' este obligatoriu")
    private StatusComanda status = StatusComanda.PRIMITA;

    @NotNull
    @NotBlank(message = "Campul 'Total' este obligatoriu")
    private Float total = 0F;

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

    public Date getData_plasarii() {
        return data_plasarii;
    }

    public void setData_plasarii(Date data_plasarii) {
        this.data_plasarii = data_plasarii;
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
