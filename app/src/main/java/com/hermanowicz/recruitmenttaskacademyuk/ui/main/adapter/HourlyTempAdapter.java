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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hermanowicz.recruitmenttaskacademyuk.databinding.RvSingleHourlyTempBinding;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.HourlyTemp;

import java.util.List;

public class HourlyTempAdapter extends
        RecyclerView.Adapter<HourlyTempAdapter.ViewHolder> {

    private RvSingleHourlyTempBinding binding;
    private final List<HourlyTemp> hourlyTempList;

    public HourlyTempAdapter(List<HourlyTemp> hourlyTempList) {
        this.hourlyTempList = hourlyTempList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final HourlyTemp hourlyTemp = hourlyTempList.get(position);

        showHourlyTemp(hourlyTemp);
    }

    private void showHourlyTemp(HourlyTemp hourlyTemp) {
        TextView hour = binding.textHour;
        TextView temp = binding.textTemperature;

        String temperature = hourlyTemp.getTemp() + "°C";
        String time = hourlyTemp.getHour() + ":00";

        hour.setText(time);
        temp.setText(temperature);
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
        binding = RvSingleHourlyTempBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(binding.getRoot());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return hourlyTempList.size();
    }
}