package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository.UtilisateurRepository;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Utils.ProviderConverter;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurDao implements UtilisateurDataAccess {
    private UtilisateurRepository utilisateurRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public UtilisateurDao(UtilisateurRepository utilisateurRepository, ProviderConverter providerConverter){
        this.utilisateurRepository = utilisateurRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Utilisateur findByUsername(String userName) {
        try {
            return providerConverter.UtilisateurEntityToUtilisateur(utilisateurRepository.findByUsername(userName));
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void add(Utilisateur utilisateur) {
        utilisateur.setId(utilisateurRepository.findAll().size()+1);
        utilisateurRepository.save(providerConverter.UtilisateurToUtilisateurEntity(utilisateur));
    }
}
