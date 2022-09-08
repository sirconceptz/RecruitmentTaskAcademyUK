package com.hermanowicz.recruitmenttaskacademyuk.ui.main.weather_details;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.HourlyTemp;

import java.util.List;

public class WeatherDetailsUseCaseImpl implements WeatherDetailsUseCase {

    private City city;
    private List<HourlyTemp> hourlyTempList;

    @Override
    public void setCityFromArguments(City city) {
        this.city = city;
        hourlyTempList = city.getHourlyTemp();
    }

    @Override
    public City getCity() {
        return city;
    }

    @Override
    public List<HourlyTemp> getHourlyTempList() {
        return hourlyTempList;
    }
}
