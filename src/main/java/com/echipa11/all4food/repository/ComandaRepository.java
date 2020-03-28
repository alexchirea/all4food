package com.echipa11.all4food.repository;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.model.Comanda;
import com.echipa11.all4food.util.StatusComanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    Comanda findComandaByComandaIdEquals(Long id);
    List<Comanda> findComandasByClientEquals(Client client);
    List<Comanda> findComandasByDataPlasariiAfter(Date data);
    List<Comanda> findComandaByStatusEquals(StatusComanda status);
}
