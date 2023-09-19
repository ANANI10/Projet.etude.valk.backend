package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Livraison;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LivraisonService {

    Livraison addLivraison(Livraison livraison);

    List<Livraison>listLivraison();

    Livraison updateLivraison(Long id  ,  Livraison livraison);

    String deleteLivraison(Long id);
}
