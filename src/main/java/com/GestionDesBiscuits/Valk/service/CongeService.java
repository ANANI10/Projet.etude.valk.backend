package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Conge;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CongeService {


    Conge addConge(Conge conge);

    List<Conge> listConge();

    Conge updateConge(Long id , Conge conge);

    String deleteConge(Long id);
}
