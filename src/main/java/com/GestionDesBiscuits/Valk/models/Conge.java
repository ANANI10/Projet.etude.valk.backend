package com.GestionDesBiscuits.Valk.models;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@DiscriminatorValue( "conge")
public class Conge extends Demande{
    private String justification;
    @Column(name = "type", insertable = false, updatable = false)
    private TypeConge type;

    public TypeConge getType() {
        return type;
    }

    public void setType(TypeConge type) {
        this.type = type;
    }

    public Conge(Date date_debut, Date date_fin, String type_demande, String justification , TypeConge type) {
        super(date_debut, date_fin, type_demande);
        this.justification = justification;
        this.type=type;
    }

    public Conge() {
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }
}
