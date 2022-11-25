package com.bptn.weatherapp.service;

import org.springframework.stereotype.Service;
import com.bptn.weatherapp.models.User;

import java.util.List;


@Service
public interface UserService {

    User findUserById(int userId) throws Exception;

    List<User> findUserByUsername(String username) throws Exception;

    User validateUserById(int userId) throws Exception;

    void deleteUserById(int userId) throws Exception;

    User updateUserById(User user) throws Exception;

    User createUser(User user) throws Exception;
}
