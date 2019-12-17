package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepositoryImplementation<UtilisateurEntity, String> {
    public UtilisateurEntity findByUsername(String username);
}
