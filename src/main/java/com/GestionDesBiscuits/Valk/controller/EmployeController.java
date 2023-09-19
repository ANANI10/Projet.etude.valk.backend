package com.GestionDesBiscuits.Valk.controller;
import com.GestionDesBiscuits.Valk.models.Employe;
import com.GestionDesBiscuits.Valk.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "valk")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @PostMapping(path = "/employee")
    public Employe ajouterEmploye(@RequestBody Employe employe){
        return employeService.add(employe);
    }

    @GetMapping(path = "/list")
    public List<Employe> listeEmploye(){
        return employeService.afficher();
    }

    @PutMapping(path = "/modifier/{id}")
    public Employe modifier(@PathVariable Long id , @RequestBody Employe employe){
        return employeService.updateEmploye(id , employe);
    }

    @DeleteMapping(path = "/supprime/{id}")
    public String supprimer( @PathVariable Long id){
        return employeService.deleteEmploye(id);
    }
}
