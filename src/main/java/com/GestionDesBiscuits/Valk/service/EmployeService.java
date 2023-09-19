package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Employe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeService {

    public Employe add(Employe employe);

    List<Employe> afficher();

    public Employe updateEmploye(Long id , Employe employe);

    public String deleteEmploye(Long id);
}
