package com.bptn.weatherapp.response;

import java.util.ArrayList;

public class WeatherApiResponse {

    private CityResponse city;
    private String cod;
    private Double message;
    private Double cnt;
    private ArrayList<ListResponse> list = new ArrayList<>();

    public CityResponse getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public Double getMessage() {
        return message;
    }

    public Double getCnt() {
        return cnt;
    }

    // Setter Methods

    public void setCity(CityResponse city) {
        this.city = city;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public void setCnt(Double cnt) {
        this.cnt = cnt;
    }

    public ArrayList<ListResponse> getList() {
        return list;
    }

    public void setList(ArrayList<ListResponse> list) {
        this.list = list;
    }
}

