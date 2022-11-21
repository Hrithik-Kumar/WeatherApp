package com.bptn.weatherapp.response;

import java.util.ArrayList;


public class ListResponse {

    private Double dt;
    private Double sunrise;
    private Double sunset;
    TempResponse temp;
    FeelsLikeResponse feels_like;
    private Double pressure;
    private Double humidity;
    ArrayList<WeatherResponse> weather = new ArrayList<>();
    private Double speed;
    private Double deg;
    private Double gust;
    private Double clouds;
    private Double pop;
    private Double rain;

    public ArrayList<WeatherResponse> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<WeatherResponse> weather) {
        this.weather = weather;
    }
    // Getter Methods

    public Double getDt() {
        return dt;
    }

    public Double getSunrise() {
        return sunrise;
    }

    public Double getSunset() {
        return sunset;
    }

    public TempResponse getTemp() {
        return temp;
    }

    public FeelsLikeResponse getFeels_like() {
        return feels_like;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getDeg() {
        return deg;
    }

    public Double getGust() {
        return gust;
    }

    public Double getClouds() {
        return clouds;
    }

    public Double getPop() {
        return pop;
    }

    public Double getRain() {
        return rain;
    }

    // Setter Methods

    public void setDt(Double dt) {
        this.dt = dt;
    }

    public void setSunrise(Double sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(Double sunset) {
        this.sunset = sunset;
    }

    public void setTemp(TempResponse temp) {
        this.temp = temp;
    }

    public void setFeels_like(FeelsLikeResponse feels_likeObject) {
        this.feels_like = feels_likeObject;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public void setDeg(Double deg) {
        this.deg = deg;
    }

    public void setGust(Double gust) {
        this.gust = gust;
    }

    public void setClouds(Double clouds) {
        this.clouds = clouds;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }
}
