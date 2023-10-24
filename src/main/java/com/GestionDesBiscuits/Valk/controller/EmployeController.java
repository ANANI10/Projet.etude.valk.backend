package com.GestionDesBiscuits.Valk.controller;
import com.GestionDesBiscuits.Valk.models.Employe;
import com.GestionDesBiscuits.Valk.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(name = "valk")
public class EmployeController {
    @Autowired
    private EmployeService employeService;

    @PostMapping(path = "/employee")
    public Employe ajouterEmploye(@RequestBody Employe employe){
        return employeService.add(employe);
    }

    @PreAuthorize("hasAuthority('SCOPE_USER')")
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

    @GetMapping(path = "/nombreTotalEmployes")
    public ResponseEntity<Long> calculerNombreTotalEmployes() {
        long nombreTotalEmployes = employeService.nombreTotalEmployes();
        return ResponseEntity.ok(nombreTotalEmployes);
    }
}
