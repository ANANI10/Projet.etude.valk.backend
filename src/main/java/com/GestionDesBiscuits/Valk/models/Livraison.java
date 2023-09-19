package com.GestionDesBiscuits.Valk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "livraison")
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "DD/MM/YYYY")
    private String date_livraison;
    private String status;
    private String lieu;
    private String adresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(String date_livraison) {
        this.date_livraison = date_livraison;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Livraison() {
    }

    public Livraison(String date_livraison, String status, String lieu, String adresse) {
        this.date_livraison = date_livraison;
        this.status = status;
        this.lieu = lieu;
        this.adresse = adresse;
    }

    @OneToMany(mappedBy = "livraison")
    public List<Employe>employes;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

}
