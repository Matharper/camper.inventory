package com.harper.brown.camper.inventory.domain.camper.service;

import com.harper.brown.camper.inventory.domain.camper.camperType.CamperType;
import com.harper.brown.camper.inventory.domain.camper.model.Camper;
import com.harper.brown.camper.inventory.domain.camper.repo.CamperRepo;
import com.harper.brown.camper.inventory.domain.core.ResourceCreationException;
import com.harper.brown.camper.inventory.domain.core.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service //marks it as a service USE EVERYTIME
public class CamperServiceImpl implements CamperService {
    private CamperRepo camperRepo;

    @Autowired
    public CamperServiceImpl(CamperRepo camperRepo){
        this.camperRepo = camperRepo;
    }

    @Override
    public Camper create(Camper camper) throws ResourceCreationException {
        Optional<Camper> optional = camperRepo.findByEmail(camper.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Camper with email exist: " +camper.getEmail());
        camper = camperRepo.save(camper);
        return camper;
    }

    @Override
    public Camper getByid(Long id) throws ResourceNotFoundException {
        Camper camper = camperRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Camper with id: " + id));
        return camper;
    }

    @Override
    public Camper getByEmail(String email) throws ResourceNotFoundException {
        Camper camper = camperRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Camper with email: " + email));
        return camper;
    }

    @Override
    public List<Camper> getAll() {
        return (List<Camper>) camperRepo.findAll();
    }

    @Override
    public List<Camper> getByCamperType(CamperType type) {
       List<Camper> campers = camperRepo.findByCamperType(type);
        return campers;
    }

    @Override
    public Camper update(Long id, Camper camperDetail) throws ResourceNotFoundException {
        Camper camper = getByid(id);
        camper.setFirstName(camperDetail.getFirstName());
        camper.setLastName(camperDetail.getLastName());
        camper.setEmail(camperDetail.getEmail());
        camper = camperRepo.save(camper);
        return camper;
    }

    @Override
    public void delete(Long id) {
        Camper camper = getByid(id);
        camperRepo.delete(camper);
    }
}
