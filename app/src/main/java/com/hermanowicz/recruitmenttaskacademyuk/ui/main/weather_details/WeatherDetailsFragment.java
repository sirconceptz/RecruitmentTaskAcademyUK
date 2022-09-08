package com.hermanowicz.recruitmenttaskacademyuk.ui.main.weather_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.hermanowicz.recruitmenttaskacademyuk.databinding.ActivityMainBinding;
import com.hermanowicz.recruitmenttaskacademyuk.databinding.FragmentWeatherDetailsBinding;

public class WeatherDetailsFragment extends Fragment {

    private WeatherDetailsViewModel viewModel;
    private FragmentWeatherDetailsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentWeatherDetailsBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(WeatherDetailsViewModel.class);

        return binding.getRoot();
    }
}