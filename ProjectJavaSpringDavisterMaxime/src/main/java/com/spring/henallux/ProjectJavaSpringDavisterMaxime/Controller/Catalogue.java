package com.spring.henallux.ProjectJavaSpringDavisterMaxime.Controller;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Constants.Constants;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.LangueDao;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.LangueDataAccess;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.ProduitDao;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.ProduitDataAccess;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Commande;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Langue;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Produit;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value = "/catalogue")
public class Catalogue {
    LangueDataAccess langueDataAccess;
    ProduitDataAccess produitDataAccess;

    @Autowired
    public Catalogue(LangueDao langueDataAccess, ProduitDao produitDataAccess){
        this.langueDataAccess = langueDataAccess;
        this.produitDataAccess = produitDataAccess;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home (Model model, Locale locale , Authentication authentication) {
        if(authentication != null && authentication.isAuthenticated())
            model.addAttribute("username", ((Utilisateur) authentication.getPrincipal()).getUsername());
        ArrayList<Produit> articles = new ArrayList<>();
        Langue langue = langueDataAccess.getLangueById(locale.getLanguage().toLowerCase());
        articles = produitDataAccess.getAll(langue);
        model.addAttribute("articles",articles);
        return "integrated:catalogue";
    }


}
