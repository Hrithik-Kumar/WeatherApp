package com.bptn.weatherapp.util;

import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.Weather;
import com.bptn.weatherapp.response.ListResponse;
import com.bptn.weatherapp.response.WeatherApiResponse;
import com.bptn.weatherapp.response.WeatherResponse;

import java.math.BigDecimal;
import java.time.Instant;

public class ResponseToEntityMapping {


    public static Weather weatherResponseMappingToWeatherEntity(WeatherApiResponse weatherApiResponse) {
        Weather weather = new Weather();
        City city = getCityMapping(weatherApiResponse);
        weather.setCityID(city);
        ListResponse listResponse = weatherApiResponse.getList().get(0);
        WeatherResponse weatherResponse = listResponse.getWeather().get(0);
        weather.setId(weatherResponse.getId());
        weather.setName(city.getName());
        weather.setDescription(weatherResponse.getDescription());
        weather.setIcon(weatherResponse.getIcon());
        weather.setFeelsLikeDay(BigDecimal.valueOf(listResponse.getFeels_like().getDay()));
        weather.setFeelsLikeMorning(BigDecimal.valueOf(listResponse.getFeels_like().getMorn()));
        weather.setFeelsLikeEvening(BigDecimal.valueOf(listResponse.getFeels_like().getEve()));
        weather.setFeelsLikeNight(BigDecimal.valueOf(listResponse.getFeels_like().getNight()));
        weather.setHumidity(BigDecimal.valueOf(listResponse.getHumidity()));
        weather.setPressure(BigDecimal.valueOf(listResponse.getPressure()));
        weather.setWindSpeed(BigDecimal.valueOf(listResponse.getSpeed()));
        weather.setWindGust(BigDecimal.valueOf(listResponse.getGust()));
        weather.setTempDay(BigDecimal.valueOf(listResponse.getTemp().getDay()));
        weather.setTempEvening(BigDecimal.valueOf(listResponse.getTemp().getEve()));
        weather.setTempMax(BigDecimal.valueOf(listResponse.getTemp().getMax()));
        weather.setTempMin(BigDecimal.valueOf(listResponse.getTemp().getMin()));
        weather.setTempMorning(BigDecimal.valueOf(listResponse.getTemp().getMorn()));
        weather.setTempNight(BigDecimal.valueOf(listResponse.getTemp().getNight()));
        weather.setUpdatedOn(Instant.now());
        weather.setCreatedOn(Instant.now());
        weather.setSunrise(Instant.ofEpochMilli(listResponse.getSunrise().longValue()));
        weather.setSunset(Instant.ofEpochMilli(listResponse.getSunset().longValue()));
        weather.setPrecipitation(BigDecimal.valueOf(listResponse.getPop()));
        weather.setWindDirection(BigDecimal.valueOf(listResponse.getDeg()));
        return weather;
    }

    private static City getCityMapping(WeatherApiResponse weatherApiResponse) {
        City city = new City();
        city.setLatitude(weatherApiResponse.getCity().getCoord().getLat());
        city.setLongitude(weatherApiResponse.getCity().getCoord().getLon());
        city.setName(weatherApiResponse.getCity().getName());
        city.setCountry(weatherApiResponse.getCity().getCountry());
        city.setPopulation(String.valueOf(weatherApiResponse.getCity().getPopulation()));
        city.setId(weatherApiResponse.getCity().getId());
        city.setTimezone(String.valueOf(weatherApiResponse.getCity().getTimezone()));
        return city;
    }
}
