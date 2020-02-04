package com.psg.projectobjectboard.nucleus.repository;
import com.psg.projectobjectboard.nucleus.EntityManagerHolder;
import com.psg.projectobjectboard.nucleus.entity.LanguageEntity;

import javax.persistence.EntityManager;

public class LanguageRepositoryImpl {

    public LanguageEntity getById(Long id){
        EntityManager entityManager =new EntityManagerHolder().getCurrentEntityManager();
        LanguageEntity languageEntity= entityManager.find(LanguageEntity.class, id);
        System.out.println("LanguageRepositoryImpl Read");
        return languageEntity;
    }
}
