package com.lacroix.lacroixnet.controller;
import com.lacroix.lacroixnet.nucleus.datatransferobject.LanguageDto;
import com.lacroix.lacroixnet.nucleus.service.LanguageService;

import java.util.Scanner;

public class LanguageController {
    private LanguageService languageService;

    public LanguageController(){this.languageService = new LanguageService();}

    public void sampleDetailLanguage(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Quel est l'identifiant de la langue dont vous voulez afficher les informations ?");
        long identifier=scanner.nextLong();
        LanguageDto languageDto= languageService.getLanguage(identifier);
        System.out.println("La langue sélectionné s'applle "+ languageDto.getName());
    }
}
