package com.bptn.weatherapp.service;

import com.bptn.weatherapp.exception.InvalidCredentialsException;
import com.bptn.weatherapp.exception.InvalidRequestException;
import com.bptn.weatherapp.exception.NoUserExistException;
import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.request.SignupRequest;

import javax.transaction.Transactional;

public interface AuthUserDetailService {

    User login(String username, String userPassword) throws InvalidRequestException, NoUserExistException, InvalidCredentialsException;
    @Transactional
    User signup(SignupRequest userDetail) throws IllegalArgumentException;


}
