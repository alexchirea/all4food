package com.echipa11.all4food.repository;

import com.echipa11.all4food.model.Comanda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandaRepository extends CrudRepository<Comanda, Long> {
}
