package com.GestionDesBiscuits.Valk.controller;

import com.GestionDesBiscuits.Valk.models.Produit;
import com.GestionDesBiscuits.Valk.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "valk")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @PostMapping(path = "/addProduct")
    public Produit ajouterProduit(@RequestBody Produit produit){
        return produitService.addProduit(produit);
    }

    @GetMapping(path = "/listAProduit")

    public List<Produit>afficherProduit(){
        return produitService.listProduit();
    }

    @PutMapping(path = "/updateProduit/{id}")
    public Produit modifierProduit(@PathVariable Long id , @RequestBody Produit produit){
        return produitService.updateProduit(id , produit);
    }

    @DeleteMapping(path = "/deleteProduit/{id}")
    public String supprimerProduit(@PathVariable Long id){
        return produitService.deleteProduit(id);
    }



}
