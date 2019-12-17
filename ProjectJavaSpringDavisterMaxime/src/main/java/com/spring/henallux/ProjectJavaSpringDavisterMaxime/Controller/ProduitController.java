package com.spring.henallux.ProjectJavaSpringDavisterMaxime.Controller;

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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;

@Controller
@RequestMapping(value = "/produit_info")
@SessionAttributes({Constants.CADDIE})
public class ProduitController {
    private LangueDataAccess langueDataAccess;
    private ProduitDataAccess produitDataAccess;

    @ModelAttribute(Constants.CADDIE)
    public  HashMap<Integer,Integer> commande(){
        return new HashMap<Integer,Integer>();
    }

    @Autowired
    public ProduitController(LangueDao langueDao, ProduitDao produitDao){
        produitDataAccess = produitDao;
        langueDataAccess = langueDao;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{reference}")
    public String infoProduit(Model model, @PathVariable("reference") int idProduit, Locale locale, @ModelAttribute(Constants.CADDIE) HashMap<Integer,Integer> commande, Authentication authentication){
        if(authentication != null && authentication.isAuthenticated())
            model.addAttribute("username", ((Utilisateur) authentication.getPrincipal()).getUsername());
        Langue langue = langueDataAccess.getLangueById(locale.getLanguage().toLowerCase());
        Produit produit = produitDataAccess.getProduitById(idProduit, langue);
        model.addAttribute("article", produit);
        Ligne ligne;
        if(!commande.containsKey(idProduit))ligne = new Ligne(produit,1);
        else ligne = new Ligne(produit,commande.get(idProduit));
        model.addAttribute("nouvelleLigne",ligne);
        return "integrated:produitInfo";
    }

    @RequestMapping (value = "send/{reference}", method = RequestMethod.POST)
    public String getFormData (Model model, @ModelAttribute(Constants.CADDIE) HashMap<Integer,Integer> commande,@PathVariable("reference") int idProduit ,@Valid @ModelAttribute(value = "nouvelleLigne") Ligne ligne, final BindingResult errors){
        if(!errors.hasErrors()){
            int quantite = ligne.getQuantite();
            if(commande.containsKey(idProduit)){
                commande.replace(idProduit,quantite);
            }else
                commande.put(idProduit,quantite);
            return "redirect:/";
        }
        return "integrated:produitInfo";

    }
}
