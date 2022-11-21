package com.bptn.weatherapp.response;

public class CityResponse {

    private int id;
    private String name;
    CoordResponse coord;
    private String country;
    private Double population;
    private Double timezone;

    // Getter Methods

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CoordResponse getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public Double getPopulation() {
        return population;
    }

    public Double getTimezone() {
        return timezone;
    }

    // Setter Methods

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoord(CoordResponse coord) {
        this.coord = coord;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public void setTimezone(Double timezone) {
        this.timezone = timezone;
    }
}

