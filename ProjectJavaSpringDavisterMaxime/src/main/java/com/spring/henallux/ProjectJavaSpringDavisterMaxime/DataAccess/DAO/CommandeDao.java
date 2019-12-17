package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository.CommandeRepository;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Utils.ProviderConverter;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Commande;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Ligne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeDao implements CommandeDataAccess {

    private ProviderConverter providerConverter;
    private CommandeRepository commandeRepository;
    private LigneDataAccess ligneDataAccess;

    @Autowired
    public CommandeDao(ProviderConverter providerConverter, CommandeRepository commandeRepository, LigneDao ligneDataAccess){
        this.providerConverter =providerConverter;
        this.commandeRepository = commandeRepository;
        this.ligneDataAccess = ligneDataAccess;
    }

    @Override
    public void addCommande(Commande commande, int utilisateur) {
        commande.setNumero( commandeRepository.findAll().size()+1);
        commandeRepository.save(providerConverter.commandeToCommandeEntity(commande,utilisateur));
        for (Ligne l: commande.getLignes()) {
            ligneDataAccess.addLigne(l,commande);
        }
    }

}
