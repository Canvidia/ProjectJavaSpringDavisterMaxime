package com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.DAO;

import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Repository.LangueRepository;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.DataAccess.Utils.ProviderConverter;
import com.spring.henallux.ProjectJavaSpringDavisterMaxime.Model.Langue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LangueDao implements LangueDataAccess {
    LangueRepository langueRepository;
    ProviderConverter providerConverter;

    @Autowired
    public LangueDao(LangueRepository langueRepository,ProviderConverter providerConverter){
        this.langueRepository = langueRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Langue getLangueById(String langue) {
        return providerConverter.LangueEntityToLangue( langueRepository.findFirstByCodeLangue(langue));
    }
}
