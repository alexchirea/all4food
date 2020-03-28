package com.echipa11.all4food.service;

import com.echipa11.all4food.model.DetaliiComanda;
import com.echipa11.all4food.repository.DetaliiComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetaliiComandaService {

    private DetaliiComandaRepository detaliiComandaRepository;

    @Autowired
    public DetaliiComandaService(DetaliiComandaRepository detaliiComandaRepository) {
        this.detaliiComandaRepository = detaliiComandaRepository;
    }

    public DetaliiComanda findById(Long id) {
        return detaliiComandaRepository.findDetaliiComandaByDetaliiComandaIdEquals(id);
    }

    public DetaliiComanda save(DetaliiComanda detaliiComanda) {
        return detaliiComandaRepository.save(detaliiComanda);
    }

    public void delete(DetaliiComanda detaliiComanda) {
        detaliiComandaRepository.delete(detaliiComanda);
    }

}
