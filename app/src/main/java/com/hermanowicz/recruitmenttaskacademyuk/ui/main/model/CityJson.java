package com.hermanowicz.recruitmenttaskacademyuk.ui.main.model;

import java.util.List;

public class CityJson {
    private String city;
    private String weather;
    private List<HourlyTemp> hourly_temp;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public List<HourlyTemp> getHourly_temp() {
        return hourly_temp;
    }

    public void setHourly_temp(List<HourlyTemp> hourly_temp) {
        this.hourly_temp = hourly_temp;
    }
}