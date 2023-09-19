package com.GestionDesBiscuits.Valk.repository;

import com.GestionDesBiscuits.Valk.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VenteRepo extends JpaRepository<Vente , Long> {
    List<Vente> findByDate(Date date);

    List<Vente> findByDateBetween(Date start, Date end);

}
