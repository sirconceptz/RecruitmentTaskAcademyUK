package com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.CityJson;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.HourlyTemp;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.repository.CitiesRepository;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.repository.CitiesRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CitiesUseCaseImpl implements CitiesUseCase {

    private final CitiesRepository repository = new CitiesRepositoryImpl();

    @Override
    public List<CityJson> getCityListFromJson() {
        return repository.getCityListFromJson();
    }

    @Override
    public List<City> getConvertedCityList() {
        List<City> cityList = new ArrayList<>();
        List<CityJson> cityJsonList = getCityListFromJson();
        for(CityJson cityJson : cityJsonList) {
            City city = new City();
            double maxTemp = getMaxTemperature(cityJson);
            city.setCity(cityJson.getCity());
            city.setWeather(cityJson.getWeather());
            city.setHourly_temp(cityJson.getHourly_temp());
            city.setMaxTemperature(maxTemp);
            cityList.add(city);
        }
        return cityList;
    }

    public double getMaxTemperature(CityJson city) {
        double maxTemperature = -100;
        for(HourlyTemp hourlyTemp : city.getHourly_temp()){
            if(maxTemperature < hourlyTemp.getTemp())
                maxTemperature = hourlyTemp.getTemp();
        }
        return maxTemperature;
    }

    @Override
    public String getSmallestTemperature() {
        List<CityJson> cityList = getCityListFromJson();
        double smallestTemperature = 100;
        for(CityJson city : cityList) {
            for(HourlyTemp hourlyTemp : city.getHourly_temp()){
                if(smallestTemperature > hourlyTemp.getTemp())
                    smallestTemperature = hourlyTemp.getTemp();
            }
        }
        return String.valueOf(smallestTemperature);
    }



}