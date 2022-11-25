package com.bptn.weatherapp.repository;

import com.bptn.weatherapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int userId);

    List<User> findUserByUsername(String username);
}
