package com.bptn.weatherapp.service.impl;

import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.repository.UserRepository;
import com.bptn.weatherapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(int userId) throws Exception {
        if (userId < 1) {
            String errorMsg = "UserId can't be negative";
            LOGGER.error(errorMsg);
            throw new Exception(errorMsg);
        }
        LOGGER.debug("Fetching User from database");
        User user = userRepository.findUserById(userId);
        if (user == null) {
            String errorMsg = "User doesn't exist with the given id";
            LOGGER.error(errorMsg);
            throw new Exception(errorMsg);
        }
        return user;
    }

    @Override
    public User validateUserById(int userId) throws Exception {
        LOGGER.debug("Validating User by UserId = {}", userId);
        return findUserById(userId);
    }


    @Override
    public void deleteUserById(int userId) throws Exception {
        User user = validateUserById(userId);
        LOGGER.debug("Deleting User for id = {}", userId);
        userRepository.delete(user);
    }

    @Override
    public User updateUserById(User user) throws Exception {
        validateUserProperties(user);
        LOGGER.debug("Updating User  = {}", user);
        return userRepository.save(user);
    }

    @Override
    public User createUser(User user) throws Exception {
        validateUserProperties(user);
        LOGGER.debug("Creating User  = {}", user);
        return userRepository.save(user);

    }

    @Override
    public User findUserByUsername(String username) throws Exception {
        if (username == null || username.length() == 0) {
            throw new Exception("Username can't be empty");
        }
        LOGGER.debug("Fetching User from database for username = {}", username);
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            String errorMsg = "User doesn't exist with the given username";
            LOGGER.error(errorMsg);
            throw new Exception(errorMsg);
        }
        return user;
    }

    private void validateUserProperties(User user) throws Exception {
        if (user == null) {
            throw new Exception("User can't be null");
        }

        if (user.getUsername() == null || user.getId() == null) {
            throw new Exception("UserName and Id can't be null");
        }

        LOGGER.info("UserProperties are validated");
    }

}
