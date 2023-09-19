package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Vente;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface VenteService {

    Vente addVente(Vente vente);

    List<Vente>listVente();

    Vente updateVente(Long id , Vente vente);

    String deleteVente(Long id);

    double calculerRevenuPourVente(Long venteId);

    double calculerRevenuTotal(List<Vente> ventes);

    double calculerSommeRevenuTotal();

    double calculerRevenuTotalParJour(Date date);

    double calculerRevenuTotalParMois(int mois, int annee);

    double calculerRevenuTotalParAnnee(int annee);

}
