package com.GestionDesBiscuits.Valk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "demande")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long Id;

    @JsonFormat(pattern= "dd/MM/yyyy")
    private String date_debut ;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String date_fin;

    private String type_demande;

    public Demande(Date date_debut, Date date_fin, String type_demande) {
    }

    public Demande() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getType_demande() {
        return type_demande;
    }

    public void setType_demande(String type_demande) {
        this.type_demande = type_demande;
    }

    public Demande(String date_debut, String date_fin, String type_demande) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.type_demande = type_demande;
    }

    public Demande(Long id) {
    }

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;
}
