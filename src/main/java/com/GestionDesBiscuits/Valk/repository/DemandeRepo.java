package com.GestionDesBiscuits.Valk.repository;

import com.GestionDesBiscuits.Valk.models.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepo extends JpaRepository<Demande , Long> {
}
