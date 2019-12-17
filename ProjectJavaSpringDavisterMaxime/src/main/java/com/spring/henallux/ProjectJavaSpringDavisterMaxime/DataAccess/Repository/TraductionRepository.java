package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.TraductionEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface TraductionRepository extends JpaRepositoryImplementation<TraductionEntity,String> {
    public ArrayList<TraductionEntity> getAllByLangue(int LangueId);
    public TraductionEntity findByProduitAndLangue(int produitId,int langueId);
}
