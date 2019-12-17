package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Table(name = "chemin_traverse_commande")
public class CommandeEntity {
    @NonNull
    @Id
    @Column(name = "numero")
    private int numero;

    @NonNull
    @Column(name ="date")
    @Temporal(TemporalType.DATE)
    private Calendar date;

    @NonNull
    @Column(name = "utilisateur")
    private int utilisateur;

    public CommandeEntity() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

}
