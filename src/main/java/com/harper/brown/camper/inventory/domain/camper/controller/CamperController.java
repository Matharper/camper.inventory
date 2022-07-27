package com.harper.brown.camper.inventory.domain.camper.controller;

import com.harper.brown.camper.inventory.domain.camper.model.Camper;
import com.harper.brown.camper.inventory.domain.camper.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oh/yeah/camping")
public class CamperController {
    private CamperService camperService;

    @Autowired
    public CamperController(CamperService camperService) {
        this.camperService = camperService;
    }

    @GetMapping
    public ResponseEntity<List<Camper>> getAll(){
        List<Camper> camper = camperService.getAll();
        return new ResponseEntity<>(camper, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Camper> create(@RequestBody Camper camper){
        camper = camperService.create(camper);
        return new ResponseEntity<>(camper, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Camper> getById(@PathVariable("id") Long id){
        Camper camper = camperService.getByid(id);
        return new ResponseEntity<>(camper, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Camper> getByEmail(@RequestParam String email){
        Camper camper = camperService.getByEmail(email);
        return new ResponseEntity<>(camper, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Camper> update(@PathVariable("id") Long id, @RequestBody Camper camperDetail){
        camperDetail = camperService.update(id, camperDetail);
        return new ResponseEntity<>(camperDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        camperService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
