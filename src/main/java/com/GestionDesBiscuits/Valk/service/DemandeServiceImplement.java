package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Demande;
import com.GestionDesBiscuits.Valk.repository.DemandeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeServiceImplement implements DemandeService{

    @Autowired
    private DemandeRepo demandeRepo;

    @Override
    public Demande addDemande(Demande demande) {
        return demandeRepo.save(demande);
    }

    @Override
    public List<Demande> listDemande() {
        return demandeRepo.findAll();
    }

    @Override
    public Demande updateDemande(Long id, Demande demande) {
        return demandeRepo.findById(id).map(p->{
            p.setDate_debut(demande.getDate_debut());
            p.setDate_fin(demande.getDate_fin());
            p.setType_demande(demande.getType_demande());
            return demandeRepo.save(p);
        }).orElseThrow(()->new RuntimeException("demande mise à jours"));
    }

    @Override
    public String deleteDemande(Long id) {
        demandeRepo.deleteById(id);
        return "demande supprimée avec succes";
    }
}
