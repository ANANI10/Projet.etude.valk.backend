package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Demande;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemandeService {

    Demande addDemande(Demande demande);

    List<Demande> listDemande();

    Demande updateDemande(Long id , Demande demande);

    String deleteDemande(Long id);

}
