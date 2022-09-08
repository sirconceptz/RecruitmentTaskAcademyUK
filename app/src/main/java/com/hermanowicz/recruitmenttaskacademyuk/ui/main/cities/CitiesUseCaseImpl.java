package com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities;

import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.CityJson;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.HourlyTemp;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.SmallestTempCity;
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
    public SmallestTempCity getSmallestDailyTemperature() {
        List<City> cityList = getConvertedCityList();
        SmallestTempCity smallestTempCity = new SmallestTempCity();
        for(City city : cityList) {
            int counter = 0;
            double sum = 0;
            for(HourlyTemp hourlyTemp : city.getHourlyTemp()){
                counter++;
                sum += hourlyTemp.getTemp();
            }
            double averageTemperature = sum / counter;
            averageTemperature = Math.round(averageTemperature * 1000d) / 1000d;
            if(smallestTempCity.getCity() == null) {
                smallestTempCity.setSmallestTemperature(averageTemperature);
                smallestTempCity.setCity(city);
            }
            else if(smallestTempCity.getSmallestTemperature() > averageTemperature) {
                smallestTempCity.setSmallestTemperature(averageTemperature);
                smallestTempCity.setCity(city);
            }
        }
        return smallestTempCity;
    }

    @Override
    public SmallestTempCity getSmallestTempAllCities() {
        List<City> cityList = getConvertedCityList();
        SmallestTempCity smallestTempCity = new SmallestTempCity();
        for(City city : cityList) {
            for(HourlyTemp hourlyTemp : city.getHourlyTemp()){
                if(smallestTempCity.getCity() == null) {
                    double temp = hourlyTemp.getTemp();
                    smallestTempCity.setCity(city);
                    smallestTempCity.setSmallestTemperature(temp);
                }
                else if(smallestTempCity.getSmallestTemperature() > hourlyTemp.getTemp()) {
                    double temp = hourlyTemp.getTemp();
                    smallestTempCity.setCity(city);
                    smallestTempCity.setSmallestTemperature(temp);
                }
            }
        }
        return smallestTempCity;
    }
}