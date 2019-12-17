package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Utils;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.TraductionDao;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.*;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.*;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class ProviderConverter {
    public ArrayList<Produit> produitEntitiesAndTranductionEntityToProduit (List<ProduitEntity> produitEntitys, List<TraductionEntity> traductionEntity){
        ArrayList<Produit> produits = new ArrayList<>();
        for (int i = 0; i < produitEntitys.size(); i++){
            Produit produit = produitEntityAndTranductionEntityToProduit(produitEntitys.get(i),traductionEntity.get(i));
            produits.add(produit);
        }
        return produits;
    }

    public Langue LangueEntityToLangue(LangueEntity langueEntity){
        Langue langue = new Langue();
        langue.setCodeLangue(langueEntity.getCodeLangue());
        langue.setId(langueEntity.getId());
        return langue;
    }
    public Produit produitEntityAndTranductionEntityToProduit(ProduitEntity produitEntity, TraductionEntity traductionEntity){
        Produit produit = new Produit();
        produit.setDescription(traductionEntity.getDescription());
        produit.setNom(traductionEntity.getNom());
        produit.setPrix(produitEntity.getPrixUnitaire());
        produit.setImage(produitEntity.getImage());
        produit.setStock(produitEntity.getStock());
        produit.setId(produitEntity.getId());
        return produit;
    }

    public Utilisateur UtilisateurEntityToUtilisateur(UtilisateurEntity utilisateurEntity){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setCredentialNonExpired(utilisateurEntity.isCredentialNonExpired());
        utilisateur.setEnabled(utilisateurEntity.isEnabled());
        utilisateur.setNonLocked(utilisateurEntity.isNonLocked());
        utilisateur.setNonExpired(utilisateurEntity.isNonExpired());
        utilisateur.setUsername(utilisateurEntity.getUsername());
        utilisateur.setPasswordValidation(utilisateurEntity.getPassword());
        utilisateur.setPassword(utilisateurEntity.getPassword());

        utilisateur.setTelephonne(utilisateurEntity.getTelephonne());
        utilisateur.setMail(utilisateurEntity.getMail());
        utilisateur.setMaison(utilisateurEntity.getMaison());

        utilisateur.setRue(utilisateurEntity.getRue());
        utilisateur.setNumero(utilisateurEntity.getNumero());
        utilisateur.setSexe(utilisateurEntity.getSexe());
        utilisateur.setPatronus(utilisateurEntity.getPatronus());
        utilisateur.setId(utilisateurEntity.getId());
        return utilisateur;
    }

    public CommandeEntity commandeToCommandeEntity(Commande commande,  int idUser) {
        CommandeEntity commandeEntity = new CommandeEntity();
        commandeEntity.setNumero(commande.getNumero());
        commandeEntity.setDate(new GregorianCalendar());
        commandeEntity.setUtilisateur(idUser);
        return commandeEntity;
    }

    public LigneEntity LigneToLigneEntity (Ligne ligne, int numCommande){
        LigneEntity ligneEntity = new LigneEntity();
        ligneEntity.setProduit(ligne.getProduit().getId());
        ligneEntity.setPrixUnitaire(ligne.getProduit().getPrix());
        ligneEntity.setQuantite(ligne.getQuantite());
        ligneEntity.setCommande(numCommande);
        return  ligneEntity;
    }

    public UtilisateurEntity UtilisateurToUtilisateurEntity(Utilisateur utilisateur){
        UtilisateurEntity utilisateurEntity = new UtilisateurEntity();
        utilisateurEntity.setCredentialNonExpired(true);
        utilisateurEntity.setEnabled(true);
        utilisateurEntity.setNonLocked(true);
        utilisateurEntity.setNonExpired(true);
        utilisateurEntity.setUsername(utilisateur.getUsername());
        utilisateurEntity.setPassword(utilisateur.getPassword());

        utilisateurEntity.setTelephonne(utilisateur.getTelephonne());
        utilisateurEntity.setMail(utilisateur.getMail());
        utilisateurEntity.setMaison(utilisateur.getMaison());

        utilisateurEntity.setRue(utilisateur.getRue());
        utilisateurEntity.setNumero(utilisateur.getNumero());
        utilisateurEntity.setSexe(utilisateur.getSexe());
        utilisateurEntity.setPatronus(utilisateur.getPatronus());
        utilisateurEntity.setId(utilisateur.getId());
        return utilisateurEntity;
    }
}
