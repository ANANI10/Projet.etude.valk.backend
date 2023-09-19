package com.GestionDesBiscuits.Valk.models;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("absence")
public class Absence extends Demande{

    public String justification;

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Absence(Date date_debut, Date date_fin, String type_demande , String justification) {
        super(date_debut, date_fin, type_demande);
        this.justification = justification;
    }

    public Absence() {
    }
}
