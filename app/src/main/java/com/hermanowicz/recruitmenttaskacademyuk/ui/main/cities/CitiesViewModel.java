package com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities;

import androidx.lifecycle.ViewModel;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;

import java.util.List;

public class CitiesViewModel extends ViewModel {

    private final CitiesUseCase useCase = new CitiesUseCaseImpl();

    public List<City> getConvertedCityList(){
        return useCase.getConvertedCityList();
    }

    public String getSmallestTemp() {
        return useCase.getSmallestTemperature();
    }
}