package com.spring.henallux.ProjectJavaSpringDavisterMaxime.Controller;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Business.CommandeBusiness;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Constants.Constants;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.LangueDao;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.LangueDataAccess;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.ProduitDao;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.ProduitDataAccess;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;

@RequestMapping(value = "/caddie")
@Controller
@SessionAttributes({Constants.CADDIE})
public class Caddie {
    LangueDataAccess langueDataAccess;
    ProduitDataAccess produitDataAccess;
    CommandeBusiness commandeBusiness;

    @ModelAttribute(Constants.CADDIE)
    public HashMap<Integer,Integer> commande(){
        return new HashMap<Integer, Integer>();
    }

    @Autowired
    public Caddie(LangueDao langueDataAccess, ProduitDao produitDataAccess, CommandeBusiness commandeBusiness){
        this.langueDataAccess = langueDataAccess;
        this.produitDataAccess = produitDataAccess;
        this.commandeBusiness = commandeBusiness;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String affiche(Model model, @ModelAttribute(Constants.CADDIE) HashMap<Integer, Integer> commande, Locale locale,Authentication authentication){
        if(authentication != null && authentication.isAuthenticated())
            model.addAttribute("username", ((Utilisateur) authentication.getPrincipal()).getUsername());
        Langue langue = langueDataAccess.getLangueById(locale.getLanguage().toLowerCase());
        HashMap<Produit, Integer>caddie  = new HashMap<Produit,Integer>();
        for (int article: commande.keySet()) {
            caddie.put(produitDataAccess.getProduitById(article,langue),commande.get(article));
        }
        model.addAttribute("ListArticle", caddie);
        return "integrated:caddie";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/remove/{reference}")
    public String retireLigne (@ModelAttribute(Constants.CADDIE) HashMap<Integer, Integer> commande, @PathVariable("reference") int produitId){
        commande.remove(produitId);
        return "redirect:/caddie";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/validate")
    public String validerCaddie (@ModelAttribute(Constants.CADDIE) HashMap<Integer, Integer> commande, Authentication authentication,Locale locale){
        Utilisateur user = (Utilisateur) authentication.getPrincipal();
        Langue langue = langueDataAccess.getLangueById(locale.getLanguage().toLowerCase());
        Commande caddie = new Commande();
        for (int article: commande.keySet()) {
            caddie.addLigne(new Ligne(produitDataAccess.getProduitById(article,langue),commande.get(article)));
        }
        commandeBusiness.commande(user,caddie);
        return "redirect:/";
    }
}
