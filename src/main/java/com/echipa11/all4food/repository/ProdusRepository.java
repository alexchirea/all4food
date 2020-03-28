package com.echipa11.all4food.repository;

import com.echipa11.all4food.model.Client;
import com.echipa11.all4food.model.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdusRepository extends JpaRepository<Produs,Long> {
    Produs findProdusByProdusIdEquals(Long id);


}
