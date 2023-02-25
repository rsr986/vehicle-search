package com.example.vehicle.api.search.controller;

import com.example.vehicle.api.search.entity.Manufacturer;
import com.example.vehicle.api.search.exception.ManufacturerNotFoundException;
import com.example.vehicle.api.search.exception.MissingFieldException;
import com.example.vehicle.api.search.service.ManufacturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/manufacturers")
public class ManufacturerController {

    ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    ResponseEntity<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer) {
        Manufacturer createdManufacturer = manufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<>(createdManufacturer, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Manufacturer>> getAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        return ResponseEntity.ok().body(manufacturers);
    }

    @GetMapping("/{id}")
    ResponseEntity<Manufacturer> getManufacturerById(@PathVariable int id) throws ManufacturerNotFoundException {
        Manufacturer manufacturer = manufacturerService.getManufacturerForId(id);
        if(manufacturer == null) {
            throw new ManufacturerNotFoundException("Manufacturer not with ID-" + id);
        }
        return ResponseEntity.ok().body(manufacturer);
    }

    @PutMapping("/{id}")
    ResponseEntity<Manufacturer> updateManufacturerById(@PathVariable int id,
                                                        @Valid @RequestBody Manufacturer manufacturer,
                                                        BindingResult result) throws MissingFieldException, ManufacturerNotFoundException {
        if(result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            throw new MissingFieldException(errors.get(0).getDefaultMessage());
        }

        Manufacturer updateManufacturer = manufacturerService.updateManufacturerById(id, manufacturer);
        if(Objects.isNull(updateManufacturer)) {
            throw new ManufacturerNotFoundException("Manufacturer not found with ID=" + id);
        }
        return new ResponseEntity<>(updateManufacturer, HttpStatus.OK);
    }

}
