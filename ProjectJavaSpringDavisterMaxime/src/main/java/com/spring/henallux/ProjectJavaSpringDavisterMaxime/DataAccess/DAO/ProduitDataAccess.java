package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Langue;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Produit;

import java.util.ArrayList;

public interface ProduitDataAccess {
    public Produit getProduitById(int produitId, Langue langue);
    public ArrayList<Produit> getAll(Langue langue);
}
