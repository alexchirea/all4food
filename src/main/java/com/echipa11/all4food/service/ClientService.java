package com.echipa11.all4food.service;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findByClientId(Long clientId) {
        return clientRepository.findClientsByClientIdEquals(clientId);
    }

    public List<Client> findByNume(String nume){
        return clientRepository.findClientsByNumeEquals(nume);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }

}
