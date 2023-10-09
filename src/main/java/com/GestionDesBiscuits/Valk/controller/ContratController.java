package com.GestionDesBiscuits.Valk.controller;

import com.GestionDesBiscuits.Valk.models.Contrat;
import com.GestionDesBiscuits.Valk.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping(name = "valk")
public class ContratController {
    @Autowired
    private ContratService contratService;

    @PostMapping(path = "/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat){
        return contratService.addContrat(contrat);
    }

    @GetMapping(path = "/listContrat")
    public List<Contrat>afficherContrat(){
        return contratService.listContrat();
    }

    @PutMapping(path = "/modifierContrat/{id}")
    public Contrat modifierContrat(@PathVariable Long id , @RequestBody Contrat contrat){
        return contratService.updateContrat(id , contrat);
    }

    @DeleteMapping(path = "/supprimerContrat/{id}")
    public String supprimerContrat(@PathVariable Long id){
        return contratService.deleteContrat(id);
    }
}
