package com.bptn.weatherapp.service.impl;

import com.bptn.weatherapp.exception.InvalidRequestException;
import com.bptn.weatherapp.exception.NoUserExistException;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.repository.UserRepository;
import com.bptn.weatherapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(int userId) throws NoUserExistException, InvalidRequestException {
        if (userId < 1) {
            String errorMsg = "UserId can't be negative";
            LOGGER.error(errorMsg);
            throw new InvalidRequestException(errorMsg);
        }
        LOGGER.debug("Fetching User from database");
        User user = userRepository.findUserById(userId);
        if (user == null) {
            String errorMsg = "User doesn't exist with the given id";
            LOGGER.error(errorMsg);
            throw new NoUserExistException(errorMsg);
        }
        return user;
    }

    @Override
    public User validateUserById(int userId) throws NoUserExistException, InvalidRequestException {
        LOGGER.debug("Validating User by UserId = {}", userId);
        return findUserById(userId);
    }


    @Override
    public void deleteUserById(int userId) throws NoUserExistException, InvalidRequestException {
        User user = validateUserById(userId);
        LOGGER.debug("Deleting User for id = {}", userId);
        userRepository.delete(user);
    }

    @Override
    public User updateUserById(User user) throws InvalidRequestException {
        validateUserProperties(user);
        LOGGER.debug("Updating User  = {}", user);
        return userRepository.save(user);
    }

    @Override
    public User createUser(User user) throws InvalidRequestException {
        validateNewUserProperties(user);
        LOGGER.debug("Creating User  = {}", user);
        return userRepository.save(user);

    }

    private void validateNewUserProperties(User user) throws InvalidRequestException {
        if (user == null) {
            throw new InvalidRequestException("User can't be null");
        }

        if (user.getUsername() == null) {
            throw new InvalidRequestException("UserName and Id can't be null");
        }
        LOGGER.info("UserProperties are validated");
    }


    @Override
    public List<User> findUserByUsername(String username) throws NoUserExistException, InvalidRequestException {
        if (username == null || username.length() == 0) {
            throw new InvalidRequestException("Username can't be empty");
        }
        LOGGER.debug("Fetching User from database for username = {}", username);
        List<User> user = userRepository.findUserByUsername(username);
        if (user == null) {
            String errorMsg = "User doesn't exist with the given username";
            LOGGER.error(errorMsg);
            throw new NoUserExistException(errorMsg);
        }
        return user;
    }

    private void validateUserProperties(User user) throws InvalidRequestException {
        if (user == null) {
            throw new InvalidRequestException("User can't be null");
        }

        if (user.getUsername() == null || user.getId() == null) {
            throw new InvalidRequestException("UserName and Id can't be null");
        }

        LOGGER.info("UserProperties are validated");
    }

}
