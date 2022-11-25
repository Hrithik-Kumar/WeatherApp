package com.bptn.weatherapp.controller;


import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users/userid/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") int userId) {
        LOGGER.debug("Executing getUserById API. Request Parameter = {}", userId);
        User user;
        try {
            user = userService.findUserById(userId);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/users/username/{userName}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("userName") String userName) {
        LOGGER.debug("Executing getUserByUsername API. Request Parameter = {}", userName);
//        User user; This is incorrect Since username is not unique
        List<User> user;
        try {
            user = userService.findUserByUsername(userName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/users")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        LOGGER.debug("Executing updateUser API. Request Parameter = {}", user);
        User response;
        try {
            response = userService.updateUserById(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

