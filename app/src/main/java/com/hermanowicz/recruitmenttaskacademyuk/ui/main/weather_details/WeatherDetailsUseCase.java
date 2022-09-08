package com.hermanowicz.recruitmenttaskacademyuk.ui.main.weather_details;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.HourlyTemp;

import java.util.List;

public interface WeatherDetailsUseCase {
    void setCityFromArguments(City city);

    City getCity();

    List<HourlyTemp> getHourlyTempList();
}