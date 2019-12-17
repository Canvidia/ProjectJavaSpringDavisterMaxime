package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository.LigneRepository;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Utils.ProviderConverter;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Commande;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Ligne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigneDao implements LigneDataAccess {
    private ProviderConverter providerConverter;
    private LigneRepository ligneRepository;

    @Autowired
    public LigneDao(ProviderConverter providerConverter, LigneRepository ligneRepository){
        this.ligneRepository =ligneRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public void addLigne(Ligne ligne, Commande commande) {
        ligneRepository.save(providerConverter.LigneToLigneEntity(ligne, commande.getNumero()));
    }
}
