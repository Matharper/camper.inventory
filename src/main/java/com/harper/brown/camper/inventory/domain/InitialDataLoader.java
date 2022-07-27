package com.harper.brown.camper.inventory.domain;

import com.harper.brown.camper.inventory.domain.camper.camperType.CamperType;
import com.harper.brown.camper.inventory.domain.camper.model.Camper;
import com.harper.brown.camper.inventory.domain.camper.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitialDataLoader implements CommandLineRunner {
    @Autowired
    private CamperService camperService;
    @Override
    public void run(String... args) throws Exception {
        Camper camper = new Camper("Mateo","Haper-Brown","matharperbrown@gmail.com", CamperType.BOYSCOTT);
    }
}
