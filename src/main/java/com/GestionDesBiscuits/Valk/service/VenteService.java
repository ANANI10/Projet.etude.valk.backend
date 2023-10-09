package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Vente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public interface VenteService {

    Vente addVente(Vente vente);

    List<Vente>listVente();

    Vente updateVente(Long id , Vente vente);

    String deleteVente(Long id);

    double calculerRevenuPourVente(Long venteId);

    double calculerRevenuTotal(List<Vente> ventes);

    double calculerSommeRevenuTotal();

    int calculateDailyRevenueByDate(Date date);
    int calculateMonthlyRevenueByMonth(int month, int year);
    int calculateYearlyRevenueByYear(int year);
    int calculateDailyRevenue(Date date);






    Long nombreTotalVentes();

}
