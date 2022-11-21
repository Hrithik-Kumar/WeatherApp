package com.bptn.weatherapp.repository;

import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    List<Weather> findWeatherByCityID(City city);
    List<Weather> findWeatherByUpdatedOn(Instant updatedOn);
    Weather findWeatherById(int id);
    List<Weather> findWeatherByCreatedOnBetween(Instant from, Instant to);
}


