package com.example.vehicle.api.search.service.impl;

import com.example.vehicle.api.search.dao.ManufacturerDAO;
import com.example.vehicle.api.search.entity.Manufacturer;
import com.example.vehicle.api.search.service.ManufacturerService;
import org.springframework.stereotype.Service;

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
}
