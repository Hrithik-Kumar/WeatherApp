package com.bptn.weatherapp.service.impl;

import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.models.Weather;
import com.bptn.weatherapp.models.WeatherHistory;
import com.bptn.weatherapp.repository.UserRepository;
import com.bptn.weatherapp.repository.WeatherHistoryRepository;
import com.bptn.weatherapp.repository.WeatherRepository;
import com.bptn.weatherapp.service.AdminService;
import com.bptn.weatherapp.service.UserService;
import com.bptn.weatherapp.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private WeatherHistoryRepository weatherHistoryRepository;


    @Override
    public void archiveWeatherDataToHistory(String fromDate, String toDate) throws Exception {
        LOGGER.debug("Archiving weather data from = {} to = {}", fromDate, toDate);
        List<Weather> weatherList = weatherService.findWeatherByCreatedOnBetween(fromDate, toDate);
        List<WeatherHistory> weatherHistoryList = new LinkedList<>();
        for (Weather weather : weatherList){
            WeatherHistory weatherHistory = new WeatherHistory();
            BeanUtils.copyProperties(weather, weatherHistory);
            weatherHistoryList.add(weatherHistory);
        }
        weatherRepository.deleteAll(weatherList);
        weatherHistoryRepository.saveAll(weatherHistoryList);
    }

    @Override
    public void deleteWeatherData(String fromDate, String toDate) throws Exception {
        LOGGER.debug("deleting weather data from = {} to = {}", fromDate, toDate);
        List<Weather> weatherList = weatherService.findWeatherByCreatedOnBetween(fromDate, toDate);
        weatherRepository.deleteAll(weatherList);
    }

    @Override
    public void deleteUser(String username) throws Exception {
        LOGGER.debug("deleting user for user = {}", username);
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new Exception("User doesn't exist");
        }
        userRepository.delete(user);
    }

}
