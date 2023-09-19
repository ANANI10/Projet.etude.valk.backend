package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Contrat;
import com.GestionDesBiscuits.Valk.repository.ContratRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContratServiceImplement implements ContratService{
    @Autowired
    private ContratRepo contratRepo;
    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepo.save(contrat);
    }

    @Override
    public List<Contrat> listContrat() {
        return contratRepo.findAll();
    }

    @Override
    public Contrat updateContrat(Long id , Contrat contrat) {
        return contratRepo.findById(id).map(p->{
            p.setDate_debut(contrat.getDate_debut());
            p.setDate_fin(contrat.getDate_fin());
            p.setDuree_contrat(contrat.getDuree_contrat());
            p.setType_contrat(contrat.getType_contrat());
            p.setStatus_contrat(contrat.getStatut_contrat());
            return contratRepo.save(p);
        }).orElseThrow(()->new RuntimeException("Contrat mis à jours "));
    }

    @Override
    public String deleteContrat(Long id) {
        contratRepo.deleteById(id);
        return "contrat supprimé avec succès";
    }
}
