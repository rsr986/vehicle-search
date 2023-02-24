package com.example.vehicle.api.search.service;

import com.example.vehicle.api.search.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    Manufacturer saveManufacturer(Manufacturer manufacturer);

    List<Manufacturer> getAllManufacturers();
}
