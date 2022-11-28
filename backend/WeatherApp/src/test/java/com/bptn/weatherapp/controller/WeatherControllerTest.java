package com.bptn.weatherapp.controller;

import com.bptn.weatherapp.AbstractTest;
import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.Weather;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.repository.WeatherRepository;
import com.google.gson.JsonParser;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class WeatherControllerTest extends AbstractTest {


    @MockBean
    private CityRepository cityRepository;

    @MockBean
    private WeatherRepository weatherRepository;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void weatherQueryTest() throws Exception {
        String country = "Bhutan";
        String uri = "/weather/query/"+ country;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType("application/json").
                accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        when(cityRepository.save(any())).thenReturn(new City());
        when(weatherRepository.save(any())).thenReturn(new Weather());
        String result =
                JsonParser.parseString(mvcResult.getResponse().getContentAsString())
                        .getAsJsonArray().get(0).getAsJsonObject().get("name").toString();
        result = result.replaceAll("\"", "");
        assertEquals(country, result);
    }


}

