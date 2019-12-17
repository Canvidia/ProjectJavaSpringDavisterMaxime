package com.spring.henallux.ProjectJavaSpringDavisterMaxime.Controller;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.UtilisateurDao;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.UtilisateurDataAccess;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/inscription")
public class Inscription {
    private UtilisateurDataAccess utilisateurDataAccess;

    @Autowired
    public Inscription(UtilisateurDao utilisateurDataAccess){
        this.utilisateurDataAccess = utilisateurDataAccess;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String inscription(Model model){
        model.addAttribute("nouvUtilisateur", new Utilisateur());
        return "integrated:inscription";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getDataForm(Model model,@Valid @ModelAttribute("nouvUtilisateur") Utilisateur utilisateur, final BindingResult errors){

        if(!errors.hasErrors() )
            if( utilisateurDataAccess.findByUsername(utilisateur.getUsername()) == null
                    && utilisateur.getPassword().compareTo(utilisateur.getPasswordValidation())==0
            ) {
                    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                    utilisateur.setPassword(encoder.encode(utilisateur.getPassword()));
                    utilisateurDataAccess.add(utilisateur);
                    return "redirect:/login";
            }

        model.addAttribute("nouvUtilisateur", utilisateur);
        return "integrated:inscription";
    }

}
