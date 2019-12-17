package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.LangueEntity;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Langue;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface LangueRepository extends JpaRepositoryImplementation<LangueEntity,String> {
    public LangueEntity findFirstByCodeLangue(String codeLangue);
}
