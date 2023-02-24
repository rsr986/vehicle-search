package com.example.vehicle.api.search.dao;

import com.example.vehicle.api.search.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerDAO extends JpaRepository<Manufacturer, Integer> {
}
