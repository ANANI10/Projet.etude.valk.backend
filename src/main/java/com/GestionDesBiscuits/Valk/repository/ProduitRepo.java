package com.GestionDesBiscuits.Valk.repository;

import com.GestionDesBiscuits.Valk.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends JpaRepository<Produit , Long> {
}
