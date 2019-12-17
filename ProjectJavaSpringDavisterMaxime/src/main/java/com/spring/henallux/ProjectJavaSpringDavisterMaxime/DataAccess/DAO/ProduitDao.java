package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.ProduitEntity;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository.ProduitRepository;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Utils.ProviderConverter;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Langue;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProduitDao implements ProduitDataAccess {
    ProduitRepository produitRepository;
    ProviderConverter providerConverter;
    TraductionDao traductionDao;

    @Autowired
    public ProduitDao(ProduitRepository produitRepository, ProviderConverter providerConverter,TraductionDao traductionDao){
        this.produitRepository = produitRepository;
        this.providerConverter = providerConverter;
        this.traductionDao = traductionDao;
    }

    @Override
    public Produit getProduitById(int produitId, Langue langue) {

        return  providerConverter.produitEntityAndTranductionEntityToProduit( produitRepository.getById(produitId), traductionDao.getTraductionProduit(produitId,langue));
    }

    @Override
    public ArrayList<Produit> getAll(Langue langue) {
        ArrayList<Produit> produits = providerConverter.produitEntitiesAndTranductionEntityToProduit( produitRepository.findAll(), traductionDao.getAll(langue));
        return produits;
    }
}
