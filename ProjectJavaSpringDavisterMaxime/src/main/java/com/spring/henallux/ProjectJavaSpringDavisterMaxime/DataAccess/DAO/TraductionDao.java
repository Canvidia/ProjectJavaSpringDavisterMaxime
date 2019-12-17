package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.TraductionEntity;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository.TraductionRepository;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Utils.ProviderConverter;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Langue;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TraductionDao implements TraductionDataAccess {
    TraductionRepository traductionRepository;
    ProviderConverter providerConverter;

    @Autowired
    public TraductionDao (ProviderConverter providerConverter, TraductionRepository traductionRepository){
        this.providerConverter = providerConverter;
        this.traductionRepository = traductionRepository;
    }

    @Override
    public ArrayList<TraductionEntity> getAll(Langue langue) {
        return traductionRepository.getAllByLangue(langue.getId());
    }

    @Override
    public TraductionEntity getTraductionProduit(int produit, Langue langue) {
        return traductionRepository.findByProduitAndLangue(produit, langue.getId());
    }
}
