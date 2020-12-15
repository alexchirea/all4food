package com.echipa11.all4food.repository;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.model.Produs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private ProdusRepository produsRepository;
    private ClientRepository clientRepository;

    @Autowired
    public DataLoader(ProdusRepository produsRepository, ClientRepository clientRepository) {
        this.produsRepository = produsRepository;
        this.clientRepository = clientRepository;
    }

    public void run(ApplicationArguments args) {
        LoadProducts();
        LoadClients();
    }

    private void LoadClients() {
        clientRepository.save(new Client("USER", "DEMO", "Str. Universitatii nr. 11", "Bucuresti", "0721345678"));
        clientRepository.save(new Client("Popescu", "Andrei", "Bd. Unirii nr. 1", "Bucuresti", "0712345678"));
        clientRepository.save(new Client("Ionescu", "Alexandra", "Bd. Unirii nr. 2", "Bucuresti", "0772345678"));
    }

    private void LoadProducts() {
        produsRepository.save(new Produs("Pizza 1", 24.50f));
        produsRepository.save(new Produs("Pizza 2", 21.0f));
        produsRepository.save(new Produs("Burger 1", 18.50f));
        produsRepository.save(new Produs("Burger 2", 14.50f));
        produsRepository.save(new Produs("Menu 1", 20.50f));
    }

}
