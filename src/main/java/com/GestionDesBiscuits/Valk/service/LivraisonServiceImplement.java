package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Livraison;
import com.GestionDesBiscuits.Valk.repository.LivraisonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivraisonServiceImplement implements LivraisonService{
    @Autowired
    private LivraisonRepo livraisonRepo;
    @Override
    public Livraison addLivraison(Livraison livraison) {
        return livraisonRepo.save(livraison);
    }

    @Override
    public List<Livraison> listLivraison() {
        return livraisonRepo.findAll();
    }

    @Override
    public Livraison updateLivraison(Long id, Livraison livraison) {
        return livraisonRepo.findById(id)
                .map(p->{
                    p.setDate_livraison(livraison.getDate_livraison());
                    p.setStatus(livraison.getStatus());
                    p.setLieu(livraison.getLieu());
                    p.setAdresse(livraison.getAdresse());
                    return livraisonRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Livraison mise à jours "));
    }

    @Override
    public String deleteLivraison(Long id) {
        livraisonRepo.deleteById(id);
        return "livraison supprimée avec succes";
    }
}
