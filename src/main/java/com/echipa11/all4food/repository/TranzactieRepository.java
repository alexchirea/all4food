package com.echipa11.all4food.repository;

import com.echipa11.all4food.model.Tranzactie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranzactieRepository extends JpaRepository<Tranzactie,Long> {
    Tranzactie findTranzactieByTranzactieIdEquals(Long id);

}
