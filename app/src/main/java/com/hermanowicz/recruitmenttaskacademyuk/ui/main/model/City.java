package com.hermanowicz.recruitmenttaskacademyuk.ui.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class City implements Parcelable {
    private String city;
    private String weather;
    private List<HourlyTemp> hourly_temp;
    private double maxTemperature;

    protected City(Parcel in) {
        city = in.readString();
        weather = in.readString();
        maxTemperature = in.readDouble();
    }

    public City(){

    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

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

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(weather);
        dest.writeDouble(maxTemperature);
    }
}