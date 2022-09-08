package com.hermanowicz.recruitmenttaskacademyuk.ui.main.weather_details;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities.CitiesFragmentDirections;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.HourlyTemp;

import java.util.List;

public class WeatherDetailsViewModel extends ViewModel {

    private WeatherDetailsUseCase useCase = new WeatherDetailsUseCaseImpl();

    public City getCityAndShowData(@NonNull WeatherDetailsFragmentArgs args) {
        useCase.setCityFromArguments(args.getCity());
        return useCase.getCity();
    }

    public List<HourlyTemp> getHourlyTempList() {
        return useCase.getHourlyTempList();
    }
}