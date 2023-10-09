package com.GestionDesBiscuits.Valk.controller;

import com.GestionDesBiscuits.Valk.models.Payement;
import com.GestionDesBiscuits.Valk.service.PayementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(name = "valk")
public class PayementController {

    @Autowired
    private PayementService payementService;

    @PostMapping(path = "/ajouterPayement")
    public Payement ajouterPayement(@RequestBody Payement payement){
        return payementService.addPayement(payement);
    }

    @GetMapping(path = "/listPayement")
    public List<Payement> afficherPayement(){
        return payementService.listPayement();
    }

    @PutMapping(name = "/updatePayement/{id}")
    public Payement updatePayement(@PathVariable Long id , @RequestBody Payement payement){
        return payementService.updatePayement(id ,payement);
    }

    @DeleteMapping(path = "/deletePayement/{id}")
    public String supprimerPayement(@PathVariable Long id){
        return payementService.deletePayement(id);
    }


}
