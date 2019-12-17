package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chemin_traverse_produit")
public class ProduitEntity {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "stock")
    private int stock;
    @Column(name = "prix_unitaire")
    private double prixUnitaire;
    @Column(name = "image")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
