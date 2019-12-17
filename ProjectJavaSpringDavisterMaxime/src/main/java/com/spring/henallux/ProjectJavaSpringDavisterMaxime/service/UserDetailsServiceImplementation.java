package com.spring.henallux.ProjectJavaSpringDavisterMaxime.service;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.UtilisateurDao;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO.UtilisateurDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UtilisateurDataAccess userDAO;

    @Autowired
    public UserDetailsServiceImplementation(UtilisateurDao userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userDAO.findByUsername(username);
        if (user != null){
            return user;
        }
        throw new UsernameNotFoundException("User not found");
    }

}