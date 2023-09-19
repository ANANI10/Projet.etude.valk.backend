package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Conge;
import com.GestionDesBiscuits.Valk.repository.CongeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongeServiceImplement implements CongeService{
    @Autowired
    private CongeRepo congeRepo;
    @Override
    public Conge addConge(Conge conge) {
        return congeRepo.save(conge) ;
    }

    @Override
    public List<Conge> listConge() {
        return congeRepo.findAll();
    }

    @Override
    public Conge updateConge(Long id, Conge conge) {
        return congeRepo.findById(id)
                .map(p->{
                    p.setDate_debut(conge.getDate_debut());
                    p.setDate_fin(conge.getDate_fin());
                    p.setType_demande(conge.getType_demande());
                    p.setJustification(conge.getJustification());
                    p.setType(conge.getType());
                    return congeRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Congé mis à jours avec succes"));
    }

    @Override
    public String deleteConge(Long id) {
        congeRepo.deleteById(id);
        return "Congé supprimé avec succes";
    }
}
