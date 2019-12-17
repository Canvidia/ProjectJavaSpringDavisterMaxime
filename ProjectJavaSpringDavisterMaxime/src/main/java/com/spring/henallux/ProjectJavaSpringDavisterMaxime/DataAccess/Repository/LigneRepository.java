package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.LigneEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneRepository extends JpaRepositoryImplementation<LigneEntity,String> {
}
