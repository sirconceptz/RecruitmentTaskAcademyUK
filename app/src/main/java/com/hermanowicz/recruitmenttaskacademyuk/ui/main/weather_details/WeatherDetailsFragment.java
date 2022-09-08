package com.hermanowicz.recruitmenttaskacademyuk.ui.main.weather_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hermanowicz.recruitmenttaskacademyuk.R;
import com.hermanowicz.recruitmenttaskacademyuk.databinding.FragmentWeatherDetailsBinding;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.adapter.HourlyTempAdapter;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.HourlyTemp;

import java.util.List;

public class WeatherDetailsFragment extends Fragment {

    private WeatherDetailsViewModel viewModel;
    private FragmentWeatherDetailsBinding binding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initView();
        showWeatherDetails();
        setupRecyclerView();

        return view;
    }

    private void showWeatherDetails() {
        City city = viewModel.getCityAndShowData(WeatherDetailsFragmentArgs.fromBundle(getArguments()));
        binding.taskTwoLabel.setText(city.getCity() + " - " + getString(R.string.forecast));
    }

    private void initView() {
        binding = FragmentWeatherDetailsBinding.inflate(getLayoutInflater());
        view = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(WeatherDetailsViewModel.class);
    }


    private void setupRecyclerView() {
        RecyclerView cities = binding.citiesTaskTwo;
        List<HourlyTemp> hourlyTempList = viewModel.getHourlyTempList();
        HourlyTempAdapter hourlyTempAdapter = new HourlyTempAdapter(hourlyTempList);

        cities.setAdapter(hourlyTempAdapter);
        cities.setLayoutManager(new LinearLayoutManager(getContext()));
        cities.setHasFixedSize(true);
        cities.setItemAnimator(new DefaultItemAnimator());
    }
}