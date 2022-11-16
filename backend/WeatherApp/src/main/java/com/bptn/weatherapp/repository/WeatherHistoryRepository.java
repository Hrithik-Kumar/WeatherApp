package com.bptn.weatherapp.repository;

import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Integer> {

    List<WeatherHistory> findWeatherByCityID(City city);

    List<WeatherHistory> findWeatherByUpdatedOn(Instant updatedOn);

    WeatherHistory findWeatherById(int id);
}

