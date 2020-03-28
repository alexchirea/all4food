package com.echipa11.all4food.service;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.model.Produs;
import com.echipa11.all4food.model.Tranzactie;
import com.echipa11.all4food.repository.ClientRepository;
import com.echipa11.all4food.repository.ProdusRepository;
import com.echipa11.all4food.repository.TranzactieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranzactieService {

    private TranzactieRepository tranzactieRepository;

    @Autowired
    public TranzactieService(TranzactieRepository tranzactieRepository) {
        this.tranzactieRepository = tranzactieRepository;
    }

    public Tranzactie findbytranzactieId(Long tranzactieId) {
        return tranzactieRepository.findTranzactieByTranzactieIdEquals(tranzactieId);
    }

    public List<Tranzactie> findAll() {
        return tranzactieRepository.findAll();
    }

    public Tranzactie findByComanda(Long id) {
        return tranzactieRepository.findTranzactieByComandaIdEquals(id);
    }

    public Tranzactie saveTranzactie(Tranzactie tranzactie) {
        return tranzactieRepository.save(tranzactie);
    }

    public void delete(Tranzactie tranzactie) {
        tranzactieRepository.delete(tranzactie);
    }

}
