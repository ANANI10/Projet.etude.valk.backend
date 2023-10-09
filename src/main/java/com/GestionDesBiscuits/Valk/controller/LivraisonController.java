package com.GestionDesBiscuits.Valk.controller;

import com.GestionDesBiscuits.Valk.models.Livraison;
import com.GestionDesBiscuits.Valk.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping(name = "valk")
public class LivraisonController {

    @Autowired
    private LivraisonService livraisonService;

    @PostMapping(path = "/addLivraison")
    public Livraison ajouterLivraison(@RequestBody Livraison livraison){
        return livraisonService.addLivraison(livraison);
    }

    @GetMapping(path = "/listLivraison")
    public List<Livraison>afficherLivraison(){
        return livraisonService.listLivraison();
    }

    @PutMapping(path = "/updateLivraison/{id}")
    public Livraison modifierLivraison(@PathVariable Long id , @RequestBody Livraison livraison){
        return livraisonService.updateLivraison(id , livraison);
    }

    @DeleteMapping(path = "/supprimerLivraison/{id}")
    public String supprimerLivraison(@PathVariable Long id){
        return livraisonService.deleteLivraison(id);
    }


}

