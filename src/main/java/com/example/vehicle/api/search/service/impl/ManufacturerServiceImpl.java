package com.example.vehicle.api.search.service.impl;

import com.example.vehicle.api.search.dao.ManufacturerDAO;
import com.example.vehicle.api.search.entity.Manufacturer;
import com.example.vehicle.api.search.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    ManufacturerDAO manufacturerDAO;

    public ManufacturerServiceImpl(ManufacturerDAO manufacturerDAO) {
        this.manufacturerDAO = manufacturerDAO;
    }

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
        return manufacturerDAO.save(manufacturer);
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerDAO.findAll();
    }

    @Override
    public Manufacturer getManufacturerForId(int id) {
        Optional<Manufacturer> manufacturer = manufacturerDAO.findById(id);
        return manufacturer.orElseGet(() -> null);
    }
}
