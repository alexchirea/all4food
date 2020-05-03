package com.echipa11.all4food.controller;

import com.echipa11.all4food.exceptions.EntityNotFoundException;
import com.echipa11.all4food.model.Produs;
import com.echipa11.all4food.service.ProdusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produse")
public class ProduseController {

    private ProdusService produsService;

    @Autowired
    public ProduseController(ProdusService produsService) {
        this.produsService = produsService;
    }

    @GetMapping
    public List<Produs> getAll() {
        return produsService.findAll();
    }

    @GetMapping("/{id}")
    public Produs getById(@PathVariable("id") Long id) {
        Produs produs = produsService.findByprodusId(id);
        if (produs == null) {
            throw new EntityNotFoundException();
        }
        return produs;
    }

    @PostMapping
    public Produs create(@RequestBody Produs produs) {
        return produsService.saveProdus(produs);
    }

    @PutMapping("/{id}")
    public Produs update(@PathVariable("id") Long id, @RequestBody Produs produs) {
        Produs produs1 = produsService.findByprodusId(id);
        if (produs1 == null) {
            throw new EntityNotFoundException();
        }
        if (produs.getDenumire() != null) produs1.setDenumire(produs.getDenumire());
        if (produs.getDescriere() != null) produs1.setDescriere(produs.getDescriere());
        if (produs.getPret() != 0) produs1.setPret(produs.getPret());
        return produsService.saveProdus((produs1));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Produs produs = produsService.findByprodusId(id);
        if (produs == null) {
            throw new EntityNotFoundException();
        }
        produsService.delete((produs));
    }

}
