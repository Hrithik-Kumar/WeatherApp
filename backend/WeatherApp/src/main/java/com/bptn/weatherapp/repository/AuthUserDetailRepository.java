package com.bptn.weatherapp.repository;

import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserDetailRepository extends JpaRepository<AuthUserDetail, Integer> {

    AuthUserDetail findAuthUserDetailByUserIDAndUserPassword(User userId, String userPassword);

}
