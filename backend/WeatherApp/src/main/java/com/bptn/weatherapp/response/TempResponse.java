package com.bptn.weatherapp.response;

public class TempResponse {
    private Double day;
    private Double min;
    private Double max;
    private Double night;
    private Double eve;
    private Double morn;

    // Getter Methods

    public Double getDay() {
        return day;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    public Double getNight() {
        return night;
    }

    public Double getEve() {
        return eve;
    }

    public Double getMorn() {
        return morn;
    }

    // Setter Methods

    public void setDay(Double day) {
        this.day = day;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public void setNight(Double night) {
        this.night = night;
    }

    public void setEve(Double eve) {
        this.eve = eve;
    }

    public void setMorn(Double morn) {
        this.morn = morn;
    }
}
