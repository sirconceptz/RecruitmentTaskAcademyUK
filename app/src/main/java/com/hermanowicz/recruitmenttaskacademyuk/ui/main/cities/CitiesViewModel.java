package com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities;

import androidx.lifecycle.ViewModel;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.SmallestTempCity;

import java.util.List;

public class CitiesViewModel extends ViewModel {

    private final CitiesUseCase useCase = new CitiesUseCaseImpl();

    public List<City> getConvertedCityList(){
        return useCase.getConvertedCityList();
    }

    public String getSmallestDailyTemp() {
        SmallestTempCity smallestTempCity =  useCase.getSmallestDailyTemperature();
        return smallestTempCity.getSmallestTemperature() + " (" + smallestTempCity.getCity().getCity() + ")";
    }

    public String getSmallestTempAllCities() {
        SmallestTempCity smallestTempCity = useCase.getSmallestTempAllCities();
        return smallestTempCity.getSmallestTemperature() + " (" + smallestTempCity.getCity().getCity() + ")";
    }
}