package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Entity.CommandeEntity;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Ligne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepositoryImplementation<CommandeEntity,String> {

    public CommandeEntity save(CommandeEntity nvCommande);

}
