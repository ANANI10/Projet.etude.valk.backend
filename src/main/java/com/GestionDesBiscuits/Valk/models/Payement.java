package com.GestionDesBiscuits.Valk.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Payement")
public class Payement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long salaire;
    @JsonFormat(pattern = "YYYY-MM-DD")
    private String  date_payement;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payement(Long salaire, String date_payement, String status) {
        this.salaire = salaire;
        this.date_payement = date_payement;
        this.status = status;
    }

    public Long getSalaire() {
        return salaire;
    }

    public void setSalaire(Long salaire) {
        this.salaire = salaire;
    }

    public String getDate_payement() {
        return date_payement;
    }

    public void setDate_payement(String date_payement) {
        this.date_payement = date_payement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payement() {
    }

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;
}

