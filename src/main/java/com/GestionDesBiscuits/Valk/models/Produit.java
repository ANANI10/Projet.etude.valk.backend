package com.GestionDesBiscuits.Valk.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom_produit;
    private int prix;
    private int quantite_produit;

    public Produit(String nom_produit, int prix, int quantite_produit) {
        this.nom_produit = nom_produit;
        this.prix = prix;
        this.quantite_produit = quantite_produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantite_produit() {
        return quantite_produit;
    }

    public void setQuantite_produit(int quantite_produit) {
        this.quantite_produit = quantite_produit;
    }

    public Produit() {
    }
    @ManyToMany(mappedBy = "produits")
    private Set<Vente> ventes = new HashSet<>();
}
