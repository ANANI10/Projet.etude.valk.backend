package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Produit;
import com.GestionDesBiscuits.Valk.repository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImplement implements ProduitService{

    @Autowired
    private ProduitRepo produitRepo;


    @Override
    public Produit addProduit(Produit produit) {
        return produitRepo.save(produit);
    }

    @Override
    public List<Produit> listProduit() {
        return produitRepo.findAll();
    }

    @Override
    public Produit updateProduit(Long id, Produit produit) {
        return produitRepo.findById(id)
                .map(p->{
                    p.setNom_produit(produit.getNom_produit());
                    p.setPrix(produit.getPrix());
                    p.setQuantite_produit(produit.getQuantite_produit());
                    return produitRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Le produit est mis à jours"));
    }

    @Override
    public String deleteProduit(Long id) {
        produitRepo.deleteById(id);
        return "Le produit est supprimé avec succes";
    }
}
