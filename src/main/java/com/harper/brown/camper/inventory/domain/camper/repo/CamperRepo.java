package com.harper.brown.camper.inventory.domain.camper.repo;

import com.harper.brown.camper.inventory.domain.camper.camperType.CamperType;
import com.harper.brown.camper.inventory.domain.camper.model.Camper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CamperRepo extends CrudRepository<Camper,Long> {
    Optional<Camper> findByEmail(String email);
    List<Camper> findByLastName(String lastName);
    List<Camper> findByCamperType(CamperType type);

}
