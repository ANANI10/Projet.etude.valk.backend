package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Absence;
import com.GestionDesBiscuits.Valk.repository.AbsenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceServiceImplement implements AbsenceService{
    @Autowired
    private AbsenceRepo absenceRepo;
    @Override
    public Absence addAbsence(Absence absence) {
        return absenceRepo.save(absence);
    }

    @Override
    public List<Absence> listAbsence() {
        return absenceRepo.findAll();
    }

    @Override
    public Absence updateAbsence(Long id, Absence absence) {
        return absenceRepo.findById(id)
                .map(p->{
                    p.setDate_debut(absence.getDate_debut());
                    p.setDate_fin(absence.getDate_fin());
                    p.setType_demande(absence.getType_demande());
                    p.setJustification(absence.getJustification());
                    return absenceRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Absence mise à jours"));
    }

    @Override
    public String deleteAbsence(Long id) {
        absenceRepo.deleteById(id);
        return "Absence supprimé avec succes";
    }
}
