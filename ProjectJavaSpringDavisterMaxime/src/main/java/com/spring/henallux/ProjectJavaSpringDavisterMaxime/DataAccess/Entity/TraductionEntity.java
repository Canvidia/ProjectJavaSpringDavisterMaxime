package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chemin_traverse_traduction")
public class TraductionEntity {
    @Id
    @Column(name = "nom")
    private String nom;
    @Column(name = "description")
    private String description;
    @Column(name = "produit")
    private int produit;
    @Column(name = "langue")
    private int langue;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public int getLangue() {
        return langue;
    }

    public void setLangue(int langue) {
        this.langue = langue;
    }
}