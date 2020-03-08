package com.echipa11.all4food.controller;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/clienti")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String addClient(Model model) {
        model.addAttribute("clienti", clientService.findAll());
        return "clienti/index";
    }

    @GetMapping("/add")
    public String addClient(Client client) {
        return "clienti/add";
    }

    @PostMapping("/add")
    public String saveClient(@Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "clienti/add";
        }
        clientService.saveClient(client);
        model.addAttribute("clienti", clientService.findAll());
        return "clienti/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client client = clientService.findByClientId(id);
        model.addAttribute("client", client);
        return "clienti/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setClientId(id);
            return "clienti/update";
        }
        client.setClientId(id);
        clientService.saveClient(client);
        model.addAttribute("clienti", clientService.findAll());
        return "clienti/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Client client = clientService.findByClientId(id);
        clientService.delete(client);
        model.addAttribute("clienti", clientService.findAll());
        return "clienti/index";
    }

}
