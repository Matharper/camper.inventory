package com.harper.brown.camper.inventory.domain.camper.service;

import com.harper.brown.camper.inventory.domain.camper.camperType.CamperType;
import com.harper.brown.camper.inventory.domain.camper.model.Camper;
import com.harper.brown.camper.inventory.domain.core.ResourceCreationException;
import com.harper.brown.camper.inventory.domain.core.ResourceNotFoundException;

import java.util.List;

public interface CamperService {
    Camper create(Camper camper) throws ResourceCreationException;
    Camper getByid(Long id) throws ResourceNotFoundException;
    Camper getByEmail(String email) throws ResourceNotFoundException;
    List<Camper> getAll();
    List<Camper> getByCamperType(CamperType type);
    Camper update (Long id, Camper camperDetail) throws ResourceNotFoundException;
    void delete(Long id);
}
