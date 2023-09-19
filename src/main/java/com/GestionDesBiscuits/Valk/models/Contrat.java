package com.GestionDesBiscuits.Valk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "YYYY-MM-DD")
    private Date date_debut;
    @JsonFormat(pattern = "YYYY-MM-DD")
    private Date date_fin;
    private int duree_contrat;
    private String type_contrat;
    private String statut_contrat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public int getDuree_contrat() {
        return duree_contrat;
    }

    public void setDuree_contrat(int duree_contrat) {
        this.duree_contrat = duree_contrat;
    }

    public String getType_contrat() {
        return type_contrat;
    }

    public void setType_contrat(String type_contrat) {
        this.type_contrat = type_contrat;
    }

    public String getStatut_contrat() {
        return statut_contrat;
    }

    public void setStatus_contrat(String statut_contrat) {
        this.statut_contrat = statut_contrat;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Contrat(Date date_debut, Date date_fin , int duree_contrat, String type_contrat , String statut_contrat) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Contrat() {
    }

    @OneToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;
}
