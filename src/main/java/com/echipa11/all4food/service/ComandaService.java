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

    public Comanda findByComandaId (Long id) {
        return comandaRepository.findComandaByComandaIdEquals(id);
    }

    public List<Comanda> findAll() {
        return comandaRepository.findAll();
    }

    public List<Comanda> findByClient (Client client) {
        return comandaRepository.findComandasByClientEquals(client);
    }

    public List<Comanda> findByDateAfter (Date data) {
        return comandaRepository.findComandasByDataPlasariiAfter(data);
    }

    public List<Comanda> findByStatus (StatusComanda status) {
        return comandaRepository.findComandaByStatusEquals(status);
    }

    public Comanda findByStatusAndClient(StatusComanda statusComanda, Client client) {
        return comandaRepository.findComandaByStatusEqualsAndClientEquals(statusComanda, client);
    }

    public Comanda save(Comanda c) {
        return comandaRepository.save(c);
    }

    public void delete(Comanda c) {
        comandaRepository.delete(c);
    }

}
