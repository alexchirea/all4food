package com.echipa11.all4food.controller;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.model.Comanda;
import com.echipa11.all4food.model.DetaliiComanda;
import com.echipa11.all4food.model.Produs;
import com.echipa11.all4food.service.ClientService;
import com.echipa11.all4food.service.ComandaService;
import com.echipa11.all4food.service.DetaliiComandaService;
import com.echipa11.all4food.service.ProdusService;
import com.echipa11.all4food.util.StatusComanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ComenziController {

    private ProdusService produsService;
    private ClientService clientService;
    private ComandaService comandaService;
    private DetaliiComandaService detaliiComandaService;
    private String clientNume = "USER";

    @Autowired
    public ComenziController(ProdusService produsService, ClientService clientService, ComandaService comandaService,
                             DetaliiComandaService detaliiComandaService) {
        this.produsService = produsService;
        this.clientService = clientService;
        this.comandaService = comandaService;
        this.detaliiComandaService = detaliiComandaService;
    }

    @GetMapping("/cos")
    public String cos(Model model) throws Exception {
        Client client = (Client) clientService.findByNume(clientNume);
        if (client == null) {
            throw new Exception("Clientul nu exista!");
        }
        Comanda comanda = comandaService.findByStatusAndClient(StatusComanda.DESCHISA, client);
        if (comanda == null) {
            throw new Exception("Nu exista nicio comanda activa!");
        }
        List<DetaliiComanda> deTrimis = detaliiComandaService.getByComanda(comanda);
        model.addAttribute("produse", deTrimis);
        model.addAttribute("comanda", comanda);
        return "cos";
    }

    @GetMapping("/cos/add/{id}")
    public String addCos(@PathVariable("id") long id, Model model) throws Exception {
        Produs produs = produsService.findByprodusId(id);
        Comanda comanda;
        if (produs == null) {
            throw new Exception("Produsul nu exista!");
        }
        Client client = (Client) clientService.findByNume(clientNume);
        if (client == null) {
            throw new Exception("Clientul nu exista!");
        }

        comanda = comandaService.findByStatusAndClient(StatusComanda.DESCHISA, client);
        if (comanda == null) {
            // se creeaza comanda noua
            Comanda comanda1 = new Comanda(client, StatusComanda.DESCHISA);
            comanda = comandaService.save(comanda1);
        }

        DetaliiComanda checkDetalii = detaliiComandaService.getByComandaAndProdus(comanda, produs);
        if (checkDetalii != null) {
            checkDetalii.setCantitate(checkDetalii.getCantitate() + 1);
            checkDetalii.setPretTotal(checkDetalii.getPretTotal() + produs.getPret());
            detaliiComandaService.save(checkDetalii);
        } else {
            DetaliiComanda produsDeAdaugat = new DetaliiComanda();
            produsDeAdaugat.setCantitate(1);
            produsDeAdaugat.setComanda(comanda);
            produsDeAdaugat.setProdus(produs);
            produsDeAdaugat.setPret(produs.getPret());
            produsDeAdaugat.setPretTotal(produs.getPret());
            produsDeAdaugat.setNumeProdus(produs.getDenumire());
            detaliiComandaService.save(produsDeAdaugat);
        }
        comanda.setTotal(comanda.getTotal() + produs.getPret());
        comandaService.save(comanda);
        List<DetaliiComanda> deTrimis = detaliiComandaService.getByComanda(comanda);
        model.addAttribute("produse", deTrimis);
        model.addAttribute("comanda", comanda);
        return "cos";
    }

    @GetMapping("/plateste/{comandaId}")
    public String plateste(@PathVariable("comandaId") long comandaId, Model model) throws Exception {
        Comanda comanda = comandaService.findByComandaId(comandaId);
        if (comanda == null) {
            throw new Exception("Nu exista comanda!");
        }
        comanda.setStatus(StatusComanda.COMPLETA);
        comandaService.save(comanda);
        model.addAttribute("comanda", comanda);
        return "plata-finalizata";
    }

}
