package com.bptn.weatherapp.service;

import com.bptn.weatherapp.models.Weather;
import java.util.List;

public interface WeatherService {

    //only for testing
    List<Weather> test(String cityName, String updatedOn, int weatherId);
}
