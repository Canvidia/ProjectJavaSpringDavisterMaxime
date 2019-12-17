package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Commande;

public interface CommandeDataAccess {
    public void addCommande(Commande commande, int utilisateur);
}
