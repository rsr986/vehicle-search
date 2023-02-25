package com.example.vehicle.api.search.service;

import com.example.vehicle.api.search.entity.Manufacturer;
import com.example.vehicle.api.search.exception.ManufacturerNotFoundException;

import java.util.List;

public interface ManufacturerService {

    Manufacturer saveManufacturer(Manufacturer manufacturer);

    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerForId(int id);

    Manufacturer updateManufacturerById(int id, Manufacturer updatedManufacturer);

    void deleteManufacturerById(int id) throws ManufacturerNotFoundException;
}
