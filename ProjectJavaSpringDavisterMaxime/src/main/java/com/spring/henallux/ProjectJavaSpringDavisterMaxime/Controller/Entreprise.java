package com.spring.henallux.ProjectJavaSpringDavisterMaxime.Controller;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Utilisateur;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/infos")
public class Entreprise {
    @RequestMapping(method = RequestMethod.GET)
    public String infos(Model model, Authentication authentication){
        if(authentication != null && authentication.isAuthenticated())
            model.addAttribute("username", ((Utilisateur) authentication.getPrincipal()).getUsername());
        return "integrated:entreprise";
    }
}
