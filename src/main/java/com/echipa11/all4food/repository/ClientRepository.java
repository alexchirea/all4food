package com.echipa11.all4food.repository;

import com.echipa11.all4food.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientsByClientIdEquals(Long id);
    Client findClientByNumeEquals(String nume);
}
