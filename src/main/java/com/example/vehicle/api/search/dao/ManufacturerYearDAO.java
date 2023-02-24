package com.example.vehicle.api.search.dao;

import com.example.vehicle.api.search.entity.ManufacturerYear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerYearDAO extends JpaRepository<ManufacturerYear, Integer> {
}
