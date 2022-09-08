package com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.CityJson;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.SmallestTempCity;

import java.util.List;

public interface CitiesUseCase {
    List<CityJson> getCityListFromJson();

    List<City> getConvertedCityList();

    SmallestTempCity getSmallestDailyTemperature();

    SmallestTempCity getSmallestTempAllCities();
}