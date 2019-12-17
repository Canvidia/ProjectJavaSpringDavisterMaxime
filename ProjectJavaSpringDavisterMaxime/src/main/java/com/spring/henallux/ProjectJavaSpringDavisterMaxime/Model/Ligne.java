package com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;

public class Ligne {
    @NonNull @Min(1)
    private int quantite;
    private Produit produit;

    public Ligne() {
        quantite = 1;
    }

    public Ligne(Produit produit, @Min(1) int quantite) {
        this.quantite = quantite;
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
