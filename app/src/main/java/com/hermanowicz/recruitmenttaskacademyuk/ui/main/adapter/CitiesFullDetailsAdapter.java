/*
 * Copyright (c) 2019-2022
 * Mateusz Hermanowicz - All rights reserved.
 * My Pantry
 * https://www.mypantry.eu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hermanowicz.recruitmenttaskacademyuk.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hermanowicz.recruitmenttaskacademyuk.R;
import com.hermanowicz.recruitmenttaskacademyuk.databinding.RvSingleCityFullDetailsBinding;
import com.hermanowicz.recruitmenttaskacademyuk.databinding.RvSingleCityWithTempBinding;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.interfaces.OnItemClickListener;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.HourlyTemp;

import java.util.List;

public class CitiesFullDetailsAdapter extends
        RecyclerView.Adapter<CitiesFullDetailsAdapter.ViewHolder> {

    private RvSingleCityFullDetailsBinding binding;
    private final OnItemClickListener clickListener;
    private final List<City> cityList;
    int itemAnimPosition = -1;

    public CitiesFullDetailsAdapter(List<City> cityList, OnItemClickListener clickListener) {
        this.cityList = cityList;
        this.clickListener = clickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final City city = cityList.get(position);

        showCity(city);
        setListener(city);
        showAnim(viewHolder);
    }

    private void showCity(City city) {
        TextView name = binding.textCityName;
        TextView weather = binding.textCityWeather;
        TextView hourlyTemp = binding.textHourlyTemp;
        String hourlyTempListInString = getHourlyTempListInString(city.getHourlyTemp());

        name.setText(city.getCity());
        weather.setText(city.getWeather());
        hourlyTemp.setText(hourlyTempListInString);
    }

    private String getHourlyTempListInString(List<HourlyTemp> hourlyTempList) {
        StringBuilder hourlyTempListInString = new StringBuilder();
        for(HourlyTemp hourlyTemp : hourlyTempList) {
            hourlyTempListInString.append(hourlyTemp.getHour()).append(":00 - (").append(hourlyTemp.getTemp()).append("°C) \n");
        }
        return hourlyTempListInString.toString();
    }

    private void setListener(City city) {
        binding.cityCardView.setOnClickListener(v -> clickListener.onItemClick(city));
    }

    private void showAnim(@NonNull ViewHolder viewHolder) {
        Context context = binding.textCityName.getContext();

        if (viewHolder.getAdapterPosition() > itemAnimPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in);
            viewHolder.itemView.startAnimation(animation);
            itemAnimPosition = viewHolder.getAdapterPosition();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        binding = RvSingleCityFullDetailsBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }
}