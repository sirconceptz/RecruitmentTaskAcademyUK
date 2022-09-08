package com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.CityJson;

import java.util.List;

public interface CitiesUseCase {
    List<CityJson> getCityListFromJson();

    List<City> getConvertedCityList();

    String getSmallestTemperature();
}