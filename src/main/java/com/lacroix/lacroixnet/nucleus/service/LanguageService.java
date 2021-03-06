package com.lacroix.lacroixnet.nucleus.service;
import com.lacroix.lacroixnet.nucleus.EntityManagerHolder;
import com.lacroix.lacroixnet.nucleus.datatransferobject.LanguageDto;
import com.lacroix.lacroixnet.nucleus.entity.LanguageEntity;
import com.lacroix.lacroixnet.nucleus.repository.LanguageRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LanguageService {
    private LanguageRepositoryImpl languageRepository;

    public LanguageService() {
        this.languageRepository = new LanguageRepositoryImpl();
    }

    public LanguageService(LanguageRepositoryImpl languageRepository) {
        this.languageRepository = languageRepository;
    }

    public LanguageDto getLanguage(Long id){
        EntityManager entityManager=null;
        EntityTransaction transaction = null;
        LanguageEntity languageEntity= null;
        LanguageDto languageDto = null;
        try{
            entityManager = new EntityManagerHolder().getCurrentEntityManager();
            transaction=entityManager.getTransaction();
            transaction.begin();
            languageEntity=languageRepository.getById(id);
            languageDto=new LanguageDto();
            languageDto.setId(languageEntity.getId());
            languageDto.setName(languageEntity.getName());
            transaction.commit();
        }
        catch (Exception e){
            if (transaction!=null)
                transaction.rollback();
            e.printStackTrace();
            System.err.println("LanguageDto no funciona");
        }
        finally {
            if (entityManager!=null)
                entityManager.close();
        }
        return languageDto;
    }
}
