package com.bptn.weatherapp.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "\"Weather\"")
public class Weather {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @Column(name = "sunrise")
    private Instant sunrise;

    @Column(name = "sunset")
    private Instant sunset;

    @Column(name = "\"tempMin\"")
    private BigDecimal tempMin;

    @Column(name = "\"tempMax\"")
    private BigDecimal tempMax;

    @Column(name = "\"tempDay\"")
    private BigDecimal tempDay;

    @Column(name = "\"tempNight\"")
    private BigDecimal tempNight;

    @Column(name = "\"tempMorning\"")
    private BigDecimal tempMorning;

    @Column(name = "\"tempEvening\"")
    private BigDecimal tempEvening;

    @Column(name = "\"feelsLikeDay\"")
    private BigDecimal feelsLikeDay;

    @Column(name = "\"feelsLikeNight\"")
    private BigDecimal feelsLikeNight;

    @Column(name = "\"feelsLikeMorning\"")
    private BigDecimal feelsLikeMorning;

    @Column(name = "\"feelsLikeEvening\"")
    private BigDecimal feelsLikeEvening;

    @Column(name = "precipitation")
    private BigDecimal precipitation;

    @Column(name = "\"windSpeed\"")
    private BigDecimal windSpeed;

    @Column(name = "\"windDirection\"")
    private BigDecimal windDirection;

    @Column(name = "\"windGust\"")
    private BigDecimal windGust;

    @Column(name = "pressure")
    private BigDecimal pressure;

    @Column(name = "humidity")
    private BigDecimal humidity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"cityID\"", nullable = false)
    private City cityID;

    @Column(name = "\"updatedOn\"")
    private Instant updatedOn;

    @Column(name = "\"createdOn\"")
    private Instant createdOn;

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getWindGust() {
        return windGust;
    }

    public void setWindGust(BigDecimal windGust) {
        this.windGust = windGust;
    }

    public BigDecimal getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(BigDecimal windDirection) {
        this.windDirection = windDirection;
    }

    public BigDecimal getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(BigDecimal windSpeed) {
        this.windSpeed = windSpeed;
    }

    public BigDecimal getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(BigDecimal precipitation) {
        this.precipitation = precipitation;
    }

    public BigDecimal getFeelsLikeEvening() {
        return feelsLikeEvening;
    }

    public void setFeelsLikeEvening(BigDecimal feelsLikeEvening) {
        this.feelsLikeEvening = feelsLikeEvening;
    }

    public BigDecimal getFeelsLikeMorning() {
        return feelsLikeMorning;
    }

    public void setFeelsLikeMorning(BigDecimal feelsLikeMorning) {
        this.feelsLikeMorning = feelsLikeMorning;
    }

    public BigDecimal getFeelsLikeNight() {
        return feelsLikeNight;
    }

    public void setFeelsLikeNight(BigDecimal feelsLikeNight) {
        this.feelsLikeNight = feelsLikeNight;
    }

    public BigDecimal getFeelsLikeDay() {
        return feelsLikeDay;
    }

    public void setFeelsLikeDay(BigDecimal feelsLikeDay) {
        this.feelsLikeDay = feelsLikeDay;
    }

    public BigDecimal getTempEvening() {
        return tempEvening;
    }

    public void setTempEvening(BigDecimal tempEvening) {
        this.tempEvening = tempEvening;
    }

    public BigDecimal getTempMorning() {
        return tempMorning;
    }

    public void setTempMorning(BigDecimal tempMorning) {
        this.tempMorning = tempMorning;
    }

    public BigDecimal getTempNight() {
        return tempNight;
    }

    public void setTempNight(BigDecimal tempNight) {
        this.tempNight = tempNight;
    }

    public BigDecimal getTempDay() {
        return tempDay;
    }

    public void setTempDay(BigDecimal tempDay) {
        this.tempDay = tempDay;
    }

    public BigDecimal getTempMax() {
        return tempMax;
    }

    public void setTempMax(BigDecimal tempMax) {
        this.tempMax = tempMax;
    }

    public BigDecimal getTempMin() {
        return tempMin;
    }

    public void setTempMin(BigDecimal tempMin) {
        this.tempMin = tempMin;
    }

    public Instant getSunset() {
        return sunset;
    }

    public void setSunset(Instant sunset) {
        this.sunset = sunset;
    }

    public Instant getSunrise() {
        return sunrise;
    }

    public void setSunrise(Instant sunrise) {
        this.sunrise = sunrise;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", tempDay=" + tempDay +
                ", tempNight=" + tempNight +
                ", tempMorning=" + tempMorning +
                ", tempEvening=" + tempEvening +
                ", feelsLikeDay=" + feelsLikeDay +
                ", feelsLikeNight=" + feelsLikeNight +
                ", feelsLikeMorning=" + feelsLikeMorning +
                ", feelsLikeEvening=" + feelsLikeEvening +
                ", precipitation=" + precipitation +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", windGust=" + windGust +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", cityID=" + cityID +
                ", updatedOn=" + updatedOn +
                ", createdOn=" + createdOn +
                '}';
    }


}


