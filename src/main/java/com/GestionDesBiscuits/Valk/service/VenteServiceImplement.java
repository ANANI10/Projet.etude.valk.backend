package com.GestionDesBiscuits.Valk.service;

import com.GestionDesBiscuits.Valk.models.Vente;
import com.GestionDesBiscuits.Valk.repository.VenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public double calculerRevenuTotalParJour(Date date) {
        // Filtrer les ventes par jour
        List<Vente> ventesParJour = venteRepo.findByDate(date);
        return calculerRevenuTotal(ventesParJour);
    }

    public double calculerRevenuTotalParMois(int mois, int annee) {
        Calendar start = Calendar.getInstance();
        start.set(annee, mois - 1, 1, 0, 0, 0);

        Calendar end = Calendar.getInstance();
        end.set(annee, mois - 1, start.getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);

        List<Vente> ventesParMois = venteRepo.findByDateBetween(start.getTime(), end.getTime());
        return calculerRevenuTotal(ventesParMois);
    }


    public double calculerRevenuTotalParAnnee(int annee) {
        Calendar start = Calendar.getInstance();
        start.set(annee, Calendar.JANUARY, 1, 0, 0, 0);

        Calendar end = Calendar.getInstance();
        end.set(annee, Calendar.DECEMBER, 31, 23, 59, 59);

        List<Vente> ventesParAnnee = venteRepo.findByDateBetween(start.getTime(), end.getTime());
        return calculerRevenuTotal(ventesParAnnee);
    }
}
