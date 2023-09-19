package com.GestionDesBiscuits.Valk.controller;
import com.GestionDesBiscuits.Valk.models.Vente;
import com.GestionDesBiscuits.Valk.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(name = "valk")
public class VenteController {
    @Autowired
    private VenteService venteService;

    @PostMapping(path = "/ajouterVente")
    public Vente ajouterVente(@RequestBody Vente vente){
        return venteService.addVente(vente);
    }

    @GetMapping(path = "/listVente")
    public List<Vente>afficherVente(){
        return venteService.listVente();
    }

    @PutMapping(path = "/modifierVente/{id}")
    public Vente modifierVente(@PathVariable Long id , @RequestBody Vente vente){
        return venteService.updateVente(id , vente);
    }

    @DeleteMapping(path = "/supprimerVente/{id}")
    public String supprimerVente(@PathVariable Long id){
        return venteService.deleteVente(id);
    }


    @GetMapping("/{id}/calculerRevenu")
    public ResponseEntity<Double> calculerRevenuPourVente(@PathVariable Long id) {
        // Appelez la méthode de calcul du revenu du service
        double revenu = venteService.calculerRevenuPourVente(id);

        // Retournez le résultat
        return ResponseEntity.ok(revenu);
    }

    @PostMapping("/calculerRevenuTotal")
    public ResponseEntity<Double> calculerRevenuTotal(@RequestBody List<Vente> ventes) {
        double revenuTotal = venteService.calculerRevenuTotal(ventes);
        return ResponseEntity.ok(revenuTotal);
    }

    @GetMapping("/calculerSommeRevenuTotal")
    public ResponseEntity<Double> calculerSommeRevenuTotal() {
        double sommeRevenuTotal = venteService.calculerSommeRevenuTotal();
        return ResponseEntity.ok(sommeRevenuTotal);
    }


    @GetMapping("/calculerRevenuTotalParJour")
    public ResponseEntity<Double> calculerRevenuTotalParJour(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        double revenuTotalParJour = venteService.calculerRevenuTotalParJour(date);
        return ResponseEntity.ok(revenuTotalParJour);
    }

    @GetMapping("/calculerRevenuTotalParMois")
    public ResponseEntity<Double> calculerRevenuTotalParMois(@RequestParam("mois") int mois, @RequestParam("annee") int annee) {
        double revenuTotalParMois = venteService.calculerRevenuTotalParMois(mois, annee);
        return ResponseEntity.ok(revenuTotalParMois);
    }

    @GetMapping("/calculerRevenuTotalParAnnee")
    public ResponseEntity<Double> calculerRevenuTotalParAnnee(@RequestParam("annee") int annee) {
        double revenuTotalParAnnee = venteService.calculerRevenuTotalParAnnee(annee);
        return ResponseEntity.ok(revenuTotalParAnnee);
    }
}
