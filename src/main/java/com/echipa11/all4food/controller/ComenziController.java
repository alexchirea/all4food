package com.echipa11.all4food.controller;

import com.echipa11.all4food.exceptions.EntityNotFoundException;
import com.echipa11.all4food.model.Comanda;
import com.echipa11.all4food.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comenzi")
public class ComenziController {

    private ComandaService comandaService;

    @Autowired
    public ComenziController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @GetMapping
    public List<Comanda> getAll() {
        return comandaService.findAll();
    }

    @GetMapping("/{id}")
    public Comanda getById(@PathVariable("id") Long id) {
        Comanda comanda = comandaService.findByComandaId(id);
        if (comanda == null) {
            throw new EntityNotFoundException();
        }
        return comanda;
    }

    @PostMapping
    public Comanda create(@RequestBody Comanda comanda) {
        return comandaService.save(comanda);
    }

    @PutMapping("/{id}")
    public Comanda update(@PathVariable("id") Long id, @RequestBody Comanda comanda) {
        Comanda comanda1 = comandaService.findByComandaId(id);
        if (comanda1 == null) {
            throw new EntityNotFoundException();
        }
        if (comanda.getStatus() != null) comanda1.setStatus(comanda.getStatus());
        return comandaService.save((comanda1));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Comanda comanda = comandaService.findByComandaId(id);
        if (comanda == null) {
            throw new EntityNotFoundException();
        }
        comandaService.delete(comanda);
    }

}
