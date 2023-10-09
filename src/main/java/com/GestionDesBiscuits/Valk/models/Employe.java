package com.GestionDesBiscuits.Valk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;


import java.util.Date;

@Entity
@Table(name = "employé")

public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @JsonFormat(pattern = "YYYY-MM-DD")
    private String date_naissance;
    private String adresse;
    private Long num_telephone;
    private Long salaire;
    private int age ;
    private String nationalite;
    private String fonction;

    public Employe() {
    }

    public Employe( String nom, String prenom, String date_naissance, String adresse, Long num_telephone, Long salaire, int age, String nationalite, String fonction) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.num_telephone = num_telephone;
        this.salaire = salaire;
        this.age = age;
        this.nationalite = nationalite;
        this.fonction = fonction;
    }

    public String getNom() {
        return nom.toUpperCase();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(Long num_telephone) {
        this.num_telephone = num_telephone;
    }

    public Long getSalaire() {
        return salaire;
    }

    public void setSalaire(Long salaire) {
        this.salaire = salaire;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "livraison_id")
    private Livraison livraison;

}
