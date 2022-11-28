package com.bptn.weatherapp.service;

import com.bptn.weatherapp.exception.InvalidRequestException;
import com.bptn.weatherapp.exception.NoUserExistException;

public interface AdminService {

    void archiveWeatherDataToHistory(String fromDate, String toDate) throws Exception;
    void deleteWeatherData(String fromDate, String toDate) throws Exception;
    void deleteUser(String username) throws NoUserExistException, InvalidRequestException;

}
