package com.GestionDesBiscuits.Valk.controller;
import com.GestionDesBiscuits.Valk.models.Vente;
import com.GestionDesBiscuits.Valk.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping(path = "/nombreTotalVente")
    public ResponseEntity<Long> calculerNombreTotalVente() {
        long nombreTotalVentes = venteService.nombreTotalVentes();
        return ResponseEntity.ok(nombreTotalVentes);
    }

    @GetMapping("/daily-revenue-by-date")
    public ResponseEntity<Integer> getDailyRevenueByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        int dailyRevenue = venteService.calculateDailyRevenueByDate(date);
        return ResponseEntity.ok(dailyRevenue);
    }

    @GetMapping("/monthly-revenue-by-month-year")
    public ResponseEntity<Integer> getMonthlyRevenueByMonthYear(
            @RequestParam int month, @RequestParam int year) {
        int monthlyRevenue = venteService.calculateMonthlyRevenueByMonth(month, year);
        return ResponseEntity.ok(monthlyRevenue);
    }

    @GetMapping("/yearly-revenue-by-year")
    public ResponseEntity<Integer> getYearlyRevenueByYear(@RequestParam int year) {
        int yearlyRevenue = venteService.calculateYearlyRevenueByYear(year);
        return ResponseEntity.ok(yearlyRevenue);
    }

}
