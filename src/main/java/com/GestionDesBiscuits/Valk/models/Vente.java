package com.GestionDesBiscuits.Valk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vente")
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "YYYY-MM-DD")
    private String date_vente;
    private int quantite_vendue;
    private int prix;
    @Temporal(TemporalType.DATE)
    private Date date;

    public Vente(String date_vente, int quantite_vendue , int prix, Date date) {
        this.date_vente = date_vente;
        this.quantite_vendue = quantite_vendue;
        this.prix = prix;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(String date_vente) {
        this.date_vente = date_vente;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantite_vendue() {
        return quantite_vendue;
    }

    public void setQuantite_vendue(int quantite_vendue) {
        this.quantite_vendue = quantite_vendue;
    }

    public Vente() {
    }

    public double calculerRevenu() {
        double revenu;
        revenu = quantite_vendue * prix;
        return revenu;
    }



    public double calculerRevenuTotal(List<Vente> ventes) {
        double revenuTotal = 0.0;

        for (Vente vente : ventes) {
                revenuTotal += vente.calculerRevenu();
        }
        return revenuTotal;
        }


    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;
}
