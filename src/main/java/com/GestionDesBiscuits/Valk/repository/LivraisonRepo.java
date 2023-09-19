package com.GestionDesBiscuits.Valk.repository;

import com.GestionDesBiscuits.Valk.models.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface LivraisonRepo extends JpaRepository<Livraison , Long> {
}
