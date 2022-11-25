package com.bptn.weatherapp.service;

import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.User;

public interface AuthUserDetailService {

    User login(String username, String userPassword) throws Exception;

    User signup(AuthUserDetail userDetail) throws Exception;


}
