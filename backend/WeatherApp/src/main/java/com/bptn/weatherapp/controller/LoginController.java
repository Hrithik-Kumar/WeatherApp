package com.bptn.weatherapp.controller;

import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.request.LoginRequest;
import com.bptn.weatherapp.service.AuthUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthUserDetailService authUserDetailService;


    @PostMapping(value = "/user/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        LOGGER.debug("Executing login API. Request Parameters = {} & {}", loginRequest.getUsername(), loginRequest.getPassword());
        User user;
        try {
            user = authUserDetailService.login(loginRequest.getUsername(), loginRequest.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/user/signup")
    public ResponseEntity<?> signup(@RequestBody AuthUserDetail authUserDetail){
        LOGGER.debug("Executing signup API. Request Parameters = {}", authUserDetail);
        User user;
        try {
            user = authUserDetailService.signup(authUserDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
