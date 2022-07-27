package com.harper.brown.camper.inventory.domain.camper.model;

import com.harper.brown.camper.inventory.domain.camper.camperType.CamperType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data//GETTERS AND SETTERS
@NoArgsConstructor//CREATED OUR DEFAULT CONSTRUCTOR
@RequiredArgsConstructor//CREATES OUR PARAMETERIZED CONSTRUCTOR
@Entity// gives Spring JPA the premission to save this object
public class Camper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private CamperType camperType;

}
