package com.bptn.weatherapp.service;

import com.bptn.weatherapp.AbstractTest;
import com.bptn.weatherapp.exception.InvalidRequestException;
import com.bptn.weatherapp.exception.NoUserExistException;
import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.repository.AuthUserDetailRepository;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.request.SignupRequest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;



public class AuthUserDetailServiceTest extends AbstractTest {

    @MockBean
    private AuthUserDetailRepository authUserDetailRepository;

    @MockBean
    private UserService userService;

    @MockBean
    private CityRepository cityRepository;

    @Autowired
    private AuthUserDetailService authUserDetailService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

//    @Test
//    public void loginTest() throws Exception {
//        String username = "test";
//        String userPassword = "test";
//        User user = new User();
//        user.setId(1);
//        user.setUsername(username);
//        when(userService.findUserByUsername(username).get(0)).thenReturn(user);
//        AuthUserDetail authUserDetail = new AuthUserDetail();
//        authUserDetail.setUserID(user);
//        when(authUserDetailRepository.findAuthUserDetailByUsernameAndUserPassword(user.getUsername(), userPassword)).
//                thenReturn(authUserDetail);
//        User result = authUserDetailService.login(username, userPassword);
//        assertEquals(user, result);
//    }

    @Test
    public void signupTest() throws IOException, NoUserExistException, InvalidRequestException {
        String signupRequestJson = "{\"username\":\"test4\",\"password\":\"test2\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"emailId\":\"johnny@gmail.com\",\"address\":\"Manchester\",\"cityName\":\"London\",\"country\":\"GB\",\"securityQuestion1\":\"What is mother maiden name?\",\"securityQuestion2\":\"What is your favourite movie?\",\"securityQuestion3\":\"Whats is your favourite sport?\",\"securityAnswer1\":\"M1\",\"securityAnswer2\":\"V1\",\"securityAnswer3\":\"S1\"}";
        SignupRequest signupRequest = mapFromJson(signupRequestJson, SignupRequest.class);
        AuthUserDetail authUserDetail = new AuthUserDetail();
        authUserDetail.setUserID(new User());
        when(authUserDetailRepository.save(any())).
                thenReturn(authUserDetail);
        City city = new City();
        when(cityRepository.findCityByName(signupRequest.getCityName())).thenReturn(city);
        doThrow(Exception.class).when(userService).findUserByUsername(signupRequest.getUsername());
        when(cityRepository.save(city)).thenReturn(city);
        when(userService.createUser(any())).thenReturn(authUserDetail.getUserID());
        when(authUserDetailRepository.save(any())).thenReturn(authUserDetail);
        User user = authUserDetailService.signup(signupRequest);
        assertEquals(authUserDetail.getUserID(), user);
    }

}

