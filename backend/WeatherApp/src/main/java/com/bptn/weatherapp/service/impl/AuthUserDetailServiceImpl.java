package com.bptn.weatherapp.service.impl;

import com.bptn.weatherapp.exception.InvalidCredentialsException;
import com.bptn.weatherapp.exception.InvalidRequestException;
import com.bptn.weatherapp.exception.NoUserExistException;
import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.repository.AuthUserDetailRepository;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.repository.UserRepository;
import com.bptn.weatherapp.request.SignupRequest;
import com.bptn.weatherapp.service.AuthUserDetailService;
import com.bptn.weatherapp.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AuthUserDetailServiceImpl implements AuthUserDetailService {

    @Autowired
    private AuthUserDetailRepository authUserDetailRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Override
    public User login(String username, String userPassword) throws InvalidRequestException, NoUserExistException, InvalidCredentialsException {
        if (username == null || userPassword == null){
            throw new InvalidRequestException("UserName or Password can't be null");
        }
        List<User> user = userService.findUserByUsername(username);
        if (user == null) {
            throw new NoUserExistException("User doesn't exist");
        }
        AuthUserDetail authUserDetail =
                authUserDetailRepository.findAuthUserDetailByUsernameAndUserPassword(user.get(0).getUsername(), userPassword);
        if (authUserDetail == null){
            throw new InvalidCredentialsException("Invalid credentials");
        }
        return user.get(0);
    }


    @Override
    public User signup(SignupRequest signupRequest) {
        City city = cityRepository.findCityByName(signupRequest.getCityName());
        if (city == null){
            city = new City();
            city.setCountry(signupRequest.getCountry());
            city.setName(signupRequest.getCityName());
        }
        User user = null;
        boolean userExists = true;
        try {
            user =  userService.findUserByUsername(signupRequest.getUsername()).get(0);
        } catch (Exception e) {
            LOGGER.info("User doesn't exist. Expected Error");
            userExists = false;

        }

        if(!userExists) {

            user = new User();
            user.setUsername(signupRequest.getUsername());
            user.setAddress(signupRequest.getAddress());
            user.setEmailID(signupRequest.getEmailId());
            user.setCreatedOn(Instant.now());
            user.setFirstName(signupRequest.getFirstName());
            user.setLastName(signupRequest.getLastName());
            user.setIsAdmin(signupRequest.isAdmin());
            user.setPhone(signupRequest.getPhone() + "");

            AuthUserDetail authUserDetail = new AuthUserDetail();
            authUserDetail.setUsername(signupRequest.getUsername());
            authUserDetail.setUserPassword(signupRequest.getPassword());
            authUserDetail.setSecurityAnswer1(signupRequest.getSecurityAnswer1());
            authUserDetail.setSecurityAnswer2(signupRequest.getSecurityAnswer2());
            authUserDetail.setSecurityAnswer3(signupRequest.getSecurityAnswer3());
            authUserDetail.setSecurityQuestion1(signupRequest.getSecurityQuestion1());
            authUserDetail.setSecurityQuestion2(signupRequest.getSecurityQuestion2());
            authUserDetail.setSecurityQuestion3(signupRequest.getSecurityQuestion3());
            city = cityRepository.save(city);
            user.setCityID(city);
            try {
                LOGGER.info(user.getUsername());
                user = userService.createUser(user);
                authUserDetail.setUserID(user);
                authUserDetailRepository.save(authUserDetail);
            } catch (Exception e) {
                LOGGER.error("Create user error");
                LOGGER.error(e.toString());
            }
        }
        return user;
    }


}




