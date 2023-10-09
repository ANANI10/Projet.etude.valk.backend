package com.GestionDesBiscuits.Valk.service;
import com.GestionDesBiscuits.Valk.models.Vente;
import com.GestionDesBiscuits.Valk.repository.VenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Calendar;
import java.util.Date;

@Service
public class VenteServiceImplement implements VenteService{
    @Autowired
    private VenteRepo venteRepo;
    @Override
    public Vente addVente(Vente vente) {
        return venteRepo.save(vente);
    }

    @Override
    public List<Vente> listVente() {
        return venteRepo.findAll();
    }

    @Override
    public Vente updateVente(Long id, Vente vente) {
        return venteRepo.findById(id)
                .map(p->{
                    p.setDate_vente(vente.getDate_vente());
                    p.setQuantite_vendue(vente.getQuantite_vendue());
                    p.setPrix(vente.getPrix());
                    return venteRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Vente mise à jours"));
    }

    @Override
    public String deleteVente(Long id) {
        venteRepo.deleteById(id);
        return "Vente supprimée avec succès";
    }

    @Override
    public double calculerRevenuPourVente(Long venteId) {
        // Chargez la vente à partir de la base de données
        Optional<Vente> venteOptional = venteRepo.findById(venteId);

        if (venteOptional.isPresent()) {
            Vente vente = venteOptional.get();
            return vente.calculerRevenu(); // Utilisez la méthode de calcul du revenu de la vente
        } else {
            System.out.println("Vente non trouvée pour l'ID : " + venteId);
        }
        return 0;
    }

    public double calculerRevenuTotal(List<Vente> ventes) {
        double revenuTotal = 0.0;

        for (Vente vente : ventes) {
            revenuTotal += vente.calculerRevenu();
        }

        return revenuTotal;
    }

    public double calculerSommeRevenuTotal() {
        List<Vente> ventes = venteRepo.findAll();  // Récupération de toutes les ventes depuis la base de données
        return calculerRevenuTotal(ventes);  // Utilisation de la méthode existante pour calculer le revenu total
    }


    @Override
    public Long nombreTotalVentes() {
        return venteRepo.count();
    }


    @Override
    public int calculateDailyRevenueByDate(Date date) {
        return calculateDailyRevenue(date);
    }

    @Override
    public int calculateDailyRevenue(Date date) {
        List<Vente> ventes = venteRepo.findByDate(date);
        int dailyRevenue = 0;

        for (Vente vente : ventes) {
            dailyRevenue += vente.getPrix() * vente.getQuantite_vendue();
        }

        return dailyRevenue;
    }

    @Override
    public int calculateMonthlyRevenueByMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);  // Mois commence à 0 (janvier)
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date startDate = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);  // Dernier jour du mois
        Date endDate = calendar.getTime();

        List<Vente> ventes = venteRepo.findByDateBetween(startDate, endDate);
        int monthlyRevenue = 0;
        for (Vente vente : ventes) {
            monthlyRevenue += vente.getPrix() * vente.getQuantite_vendue();
        }
        return monthlyRevenue;
    }

    @Override
    public int calculateYearlyRevenueByYear(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date startDate = calendar.getTime();
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 31);

        Date endDate = calendar.getTime();

        List<Vente> ventes = venteRepo.findByDateBetween(startDate, endDate);
        int yearlyRevenue = 0;
        for (Vente vente : ventes) {
            yearlyRevenue += vente.getPrix() * vente.getQuantite_vendue();
        }
        return yearlyRevenue;
    }
}

