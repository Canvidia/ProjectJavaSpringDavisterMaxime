package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.TraductionEntity;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Langue;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Produit;

import java.util.ArrayList;

public interface TraductionDataAccess {
    ArrayList<TraductionEntity> getAll(Langue langue);
    TraductionEntity getTraductionProduit(int produit, Langue langue);
}
