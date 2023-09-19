package com.GestionDesBiscuits.Valk.controller;

import com.GestionDesBiscuits.Valk.models.Conge;
import com.GestionDesBiscuits.Valk.service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "valk")

public class CongeController {
    @Autowired
    private CongeService congeService;

    @PostMapping(path = "/ajouter")
    public Conge ajouterConger(@RequestBody Conge conge){
        return congeService.addConge(conge);
    }

    @GetMapping(path = "/listConge")
    public List<Conge>listConge(){
        return  congeService.listConge();
    }

    @PutMapping(path = "/modifierConge/{id}")
    public Conge updateConge(@PathVariable Long id ,@RequestBody Conge conge){
        return congeService.updateConge(id , conge);
    }

    @DeleteMapping(path = "/deleteConge/{id}")
    public String deleteConge(@PathVariable Long id){
        return congeService.deleteConge(id);
    }
}
