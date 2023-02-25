package com.example.vehicle.api.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Manufacturer name is required")
    @NotEmpty(message = "Manufacturer name is required")
    @NotNull(message = "Manufacturer name is required")
    @Column(name = "manufacturer_name")
    private String name;
    @Column(name = "country_of_origin")
    private String originCountry;
}
