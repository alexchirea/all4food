package com.echipa11.all4food.repository;

import com.echipa11.all4food.model.Comanda;
import com.echipa11.all4food.model.DetaliiComanda;
import com.echipa11.all4food.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetaliiComandaRepository extends JpaRepository<DetaliiComanda, Long> {
    DetaliiComanda findDetaliiComandaByDetaliiComandaIdEquals(Long id);
    DetaliiComanda findDetaliiComandaByComandaEqualsAndProdusEquals(Comanda comanda, Produs produs);
    List<DetaliiComanda> findDetaliiComandasByComandaEquals(Comanda c);
}
