package com.bptn.weatherapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.repository.UserRepository;


@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    public User getUser(int userId) {
        LOGGER.info("User id passed is {}", userId);
        return userRepository.findUserById(userId);
    }

}
