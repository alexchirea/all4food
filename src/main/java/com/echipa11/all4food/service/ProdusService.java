package com.echipa11.all4food.service;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.model.Produs;
import com.echipa11.all4food.repository.ClientRepository;
import com.echipa11.all4food.repository.ProdusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdusService {

    private ProdusRepository produsRepository;

    @Autowired
    public ProdusService(ProdusRepository ProdusRepository) {
        this.produsRepository = ProdusRepository;
    }

    public Produs findByprodusId(Long produsId) {
        return produsRepository.findProdusByProdusIdEquals(produsId);
    }

    public List<Produs> findAll() {
        return produsRepository.findAll();
    }

    public Produs saveProdus(Produs produs) {
        return produsRepository.save(produs);
    }

    public void delete(Produs produs) {
        produsRepository.delete(produs);
    }

}
