package com.bptn.weatherapp.repository;

import com.bptn.weatherapp.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
    City findCityByName(String name);
}

