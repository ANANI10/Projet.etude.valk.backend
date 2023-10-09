package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Employe;
import com.GestionDesBiscuits.Valk.repository.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImplément implements EmployeService{
    @Autowired
    private EmployeRepo employeRepo;

    @Override
    public Employe add(Employe employe) {
        return employeRepo.save(employe);
    }

    @Override
    public List<Employe> afficher() {
        return employeRepo.findAll();
    }

    @Override
    public Employe updateEmploye(Long id, Employe employe) {
        return employeRepo.findById(id)
                .map(p-> {
                    p.setNom(employe.getNom());
                    p.setPrenom(employe.getPrenom());
                    p.setDate_naissance(employe.getDate_naissance());
                    p.setAdresse(employe.getAdresse());
                    p.setNum_telephone(employe.getNum_telephone());
                    p.setSalaire(employe.getSalaire());
                    p.setAge(employe.getAge());
                    p.setNationalite(employe.getNationalite());
                    p.setNationalite(employe.getFonction());
                    return employeRepo.save(p);
                } ).orElseThrow(()->new RuntimeException("Mise à jours de la table Employe"));
    }


    @Override
    public String deleteEmploye(Long id) {
        employeRepo.deleteById(id);
        return "Employé supprime avec succes";
    }

    @Override
    public Long nombreTotalEmployes() {
        return employeRepo.count();
    }
}
