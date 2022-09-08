package com.hermanowicz.recruitmenttaskacademyuk.ui.main.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.CityJson;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public class CitiesRepositoryImpl implements CitiesRepository {

    @Override
    public List<CityJson> getCityListFromJson() {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<CityJson>>(){}.getType();
        String jsonString = "[\n" +
                "  {\n" +
                "    \"city\":\"Warsaw\",\n" +
                "    \"weather\":\"rainy\",\n" +
                "    \"hourly_temp\":[\n" +
                "      { \"temp\":-2, \"hour\":0 },\n" +
                "      { \"temp\":-2, \"hour\":4 },\n" +
                "      { \"temp\":0.5, \"hour\":8 },\n" +
                "      { \"temp\":2, \"hour\":12 },\n" +
                "      { \"temp\":3, \"hour\":16 },\n" +
                "      { \"temp\":-1, \"hour\":20 }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"city\":\"Paris\",\n" +
                "    \"weather\":\"cloudy\",\n" +
                "    \"hourly_temp\":[\n" +
                "      { \"temp\":11, \"hour\":0 },\n" +
                "      { \"temp\":14, \"hour\":4 },\n" +
                "      { \"temp\":18, \"hour\":8 },\n" +
                "      { \"temp\":22, \"hour\":12 },\n" +
                "      { \"temp\":15, \"hour\":16 },\n" +
                "      { \"temp\":13, \"hour\":20 }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"city\":\"Berlin\",\n" +
                "    \"weather\":\"sunny\",\n" +
                "    \"hourly_temp\":[\n" +
                "      { \"temp\":-6, \"hour\":0 },\n" +
                "      { \"temp\":-4, \"hour\":4 },\n" +
                "      { \"temp\":2, \"hour\":8 },\n" +
                "      { \"temp\":4, \"hour\":12 },\n" +
                "      { \"temp\":5.5, \"hour\":16 },\n" +
                "      { \"temp\":3, \"hour\":20 }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"city\":\"New York\",\n" +
                "    \"weather\":\"cloudy\",\n" +
                "    \"hourly_temp\":[\n" +
                "      { \"temp\":12, \"hour\":0 },\n" +
                "      { \"temp\":13, \"hour\":4 },\n" +
                "      { \"temp\":12, \"hour\":8 },\n" +
                "      { \"temp\":15, \"hour\":12 },\n" +
                "      { \"temp\":16, \"hour\":16 },\n" +
                "      { \"temp\":14, \"hour\":20 }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        return gson.fromJson(jsonString, collectionType);
    }
}