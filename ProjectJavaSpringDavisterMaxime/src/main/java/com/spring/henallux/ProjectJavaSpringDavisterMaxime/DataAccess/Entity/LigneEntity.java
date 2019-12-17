package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chemin_traverse_ligne")
public class LigneEntity {
    @Id
    int id;

    @Column(name="produit")
    int produit;
    @Column(name = "quantite")
    int quantite;
    @Column(name = "commande")
    int commande;
    @Column(name = "prix_unitaire")
    double prixUnitaire;

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
