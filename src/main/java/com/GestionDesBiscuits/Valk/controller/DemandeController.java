package com.GestionDesBiscuits.Valk.controller;

import com.GestionDesBiscuits.Valk.models.Demande;
import com.GestionDesBiscuits.Valk.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "valk")
public class DemandeController {
    @Autowired
    private DemandeService demandeService;

    @PostMapping(path = "/ajouterDemande")
    public Demande ajouterDemande(@RequestBody Demande demande){
        return demandeService.addDemande(demande);
    }

    @GetMapping(path = "/listDemande")
    public List<Demande> listDemande(){
        return demandeService.listDemande();
    }

    @PutMapping(path = "/update/{id}")
    public Demande updateDemande(@PathVariable Long id ,@RequestBody Demande demande){
        return demandeService.updateDemande(id , demande);
    }

    @DeleteMapping(path = "/supprimerDemande/{id}")
    public String supprimerDemande(@PathVariable Long id){
        return demandeService.deleteDemande(id);
    }



}
