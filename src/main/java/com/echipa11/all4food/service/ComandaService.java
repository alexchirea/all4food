package com.echipa11.all4food.service;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.model.Comanda;
import com.echipa11.all4food.repository.ComandaRepository;
import com.echipa11.all4food.util.StatusComanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComandaService {

    private ComandaRepository comandaRepository;

    @Autowired
    public ComandaService(ComandaRepository comandaRepository) {
        this.comandaRepository = comandaRepository;
    }

    Comanda findByComandaId (Long id) {
        return comandaRepository.findComandaByComandaIdEquals(id);
    }

    List<Comanda> findByClient (Client client) {
        return comandaRepository.findComandasByClientEquals(client);
    }

    List<Comanda> findByDateAfter (Date data) {
        return comandaRepository.findComandasByData_plasariiAfter(data);
    }

    List<Comanda> findByStatus (StatusComanda status) {
        return comandaRepository.findComandaByStatusEquals(status);
    }

}
