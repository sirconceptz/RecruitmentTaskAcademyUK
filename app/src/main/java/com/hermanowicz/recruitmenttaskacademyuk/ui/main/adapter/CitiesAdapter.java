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
import com.hermanowicz.recruitmenttaskacademyuk.databinding.RvSingleCityBinding;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;

import java.util.List;

public class CitiesAdapter extends
        RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    private RvSingleCityBinding binding;
    private OnItemClickListener clickListener;
    private final List<City> cityList;
    int itemAnimPosition = -1;

    public CitiesAdapter (List<City> cityList, OnItemClickListener clickListener) {
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
        TextView maxTemp = binding.textCityMaxTemperature;

        String maxTemperature = city.getMaxTemperature() + "°C";

        name.setText(city.getCity());
        maxTemp.setText(maxTemperature);
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
        binding = RvSingleCityBinding.inflate(layoutInflater, parent, false);

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

    public interface OnItemClickListener {
        void onItemClick(City city);
    }
}