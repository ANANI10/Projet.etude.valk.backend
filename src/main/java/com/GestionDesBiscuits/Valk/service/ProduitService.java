package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProduitService {

    Produit addProduit(Produit produit);

    List<Produit>listProduit();

    Produit updateProduit(Long id , Produit produit);

    String deleteProduit(Long id);

    Optional<Produit> findById(Long id);

}
