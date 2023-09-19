package com.GestionDesBiscuits.Valk.repository;

import com.GestionDesBiscuits.Valk.models.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepo extends JpaRepository<Contrat , Long> {
}
