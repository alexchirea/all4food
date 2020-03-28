package com.echipa11.all4food.repository;

import com.echipa11.all4food.model.DetaliiComanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetaliiComandaRepository extends JpaRepository<DetaliiComanda, Long> {
    DetaliiComanda findDetaliiComandaByDetaliiComandaIdEquals(Long id);
}
