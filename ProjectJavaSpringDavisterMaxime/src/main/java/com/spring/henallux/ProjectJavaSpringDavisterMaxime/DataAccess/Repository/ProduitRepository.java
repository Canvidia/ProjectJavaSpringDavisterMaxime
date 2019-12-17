package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.ProduitEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepositoryImplementation<ProduitEntity,String> {
    public ProduitEntity getById (int id);
}
