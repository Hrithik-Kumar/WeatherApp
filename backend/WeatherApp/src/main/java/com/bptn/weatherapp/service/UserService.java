package com.bptn.weatherapp.service;

import com.bptn.weatherapp.exception.InvalidRequestException;
import com.bptn.weatherapp.exception.NoUserExistException;
import org.springframework.stereotype.Service;
import com.bptn.weatherapp.models.User;

import java.util.List;


@Service
public interface UserService {

    User findUserById(int userId) throws NoUserExistException, InvalidRequestException;

    List<User> findUserByUsername(String username) throws NoUserExistException, InvalidRequestException;

    User validateUserById(int userId) throws InvalidRequestException, NoUserExistException;

    void deleteUserById(int userId) throws InvalidRequestException, NoUserExistException;

    User updateUserById(User user) throws InvalidRequestException;

    User createUser(User user) throws InvalidRequestException ;
}
