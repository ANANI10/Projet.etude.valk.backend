package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Contrat;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ContratService {

    Contrat addContrat(Contrat contrat);

    List<Contrat> listContrat();

    Contrat updateContrat(Long id ,  Contrat contrat);

    String deleteContrat(Long id);
}
