package com.hermanowicz.recruitmenttaskacademyuk.ui.main.repository;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.CityJson;

import java.util.List;

public interface CitiesRepository {
    List<CityJson> getCityListFromJson();
}