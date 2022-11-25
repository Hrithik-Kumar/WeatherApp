package com.bptn.weatherapp.service.impl;

import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.repository.AuthUserDetailRepository;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.repository.UserRepository;
import com.bptn.weatherapp.service.AuthUserDetailService;
import com.bptn.weatherapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    @Override
    public User login(String username, String userPassword) throws Exception {
        if (username == null || userPassword == null){
            throw new Exception("UserName or Password can't be null");
        }
        List<User> user = userService.findUserByUsername(username);
        if (user == null) {
            throw new Exception("User doesn't exist");
        }
        AuthUserDetail authUserDetail =
                authUserDetailRepository.findAuthUserDetailByUsernameAndUserPassword(user.get(0).getUsername(), userPassword);
        if (authUserDetail == null){
            throw new Exception("Invalid credentials");
        }
        return user.get(0);
    }

    @Override
    public User signup(AuthUserDetail userDetail) {
        cityRepository.save(userDetail.getUserID().getCityID());
        userRepository.save(userDetail.getUserID());
        authUserDetailRepository.save(userDetail);
        return userDetail.getUserID();
    }


}
