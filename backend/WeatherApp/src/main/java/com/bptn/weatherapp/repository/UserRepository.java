package com.bptn.weatherapp.repository;

import com.bptn.weatherapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int userId);

    User findUserByUsername(String username);
}
