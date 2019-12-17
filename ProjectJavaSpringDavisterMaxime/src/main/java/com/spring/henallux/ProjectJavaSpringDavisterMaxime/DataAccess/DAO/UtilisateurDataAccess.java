package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Utilisateur;


public interface UtilisateurDataAccess {
    public Utilisateur findByUsername(String userName);
    public void add(Utilisateur utilisateur);
}
