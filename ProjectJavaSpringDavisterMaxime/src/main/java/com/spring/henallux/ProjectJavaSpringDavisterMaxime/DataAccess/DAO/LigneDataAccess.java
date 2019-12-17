package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Commande;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Ligne;

public interface LigneDataAccess {
    public void addLigne(Ligne ligne , Commande commande);
}
