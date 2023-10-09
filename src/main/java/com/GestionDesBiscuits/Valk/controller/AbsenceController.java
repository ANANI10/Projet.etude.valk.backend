package com.GestionDesBiscuits.Valk.controller;

import com.GestionDesBiscuits.Valk.models.Absence;
import com.GestionDesBiscuits.Valk.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(name = "valk")
public class AbsenceController {
    @Autowired
    private AbsenceService absenceService;

    @PostMapping(path = "/ajouterAbsence")
    public Absence ajouterAbsence(@RequestBody Absence absence){
        return absenceService.addAbsence(absence);
    }

    @GetMapping(path = "/listAbsence")
    public List<Absence> AfficherAbsence(){
        return absenceService.listAbsence();
    }

    @PutMapping(path = "/update/{id}")
    public Absence modifierAbsence(@PathVariable Long id  , @RequestBody Absence absence){
        return absenceService.updateAbsence(id , absence);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String SupprimerAbsence(Long id){
        return absenceService.deleteAbsence(id);
    }
}
