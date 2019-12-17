package com.spring.henallux.ProjectJavaSpringDavisterMaxime.Business;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.CommandeDao;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.CommandeDataAccess;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Commande;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandeBusiness {

    private CommandeDataAccess commandeDataAccess;

    @Autowired
    public CommandeBusiness(CommandeDao commandeDataAccess){
        this.commandeDataAccess = commandeDataAccess;
    }

    public boolean commande(Utilisateur utilisateur, Commande commande){
        if(payementReussi()){
            commandeDataAccess.addCommande(commande,utilisateur.getId());
        }
        return payementReussi();
    }
    private boolean payementReussi(){
        return true;
    }
}
