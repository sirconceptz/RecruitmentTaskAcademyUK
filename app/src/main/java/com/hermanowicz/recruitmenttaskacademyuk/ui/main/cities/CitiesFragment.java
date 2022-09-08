package com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hermanowicz.recruitmenttaskacademyuk.R;
import com.hermanowicz.recruitmenttaskacademyuk.databinding.FragmentCitiesBinding;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.adapter.CitiesAdapter;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.weather_details.WeatherDetailsFragment;

import java.util.List;

public class CitiesFragment extends Fragment implements CitiesAdapter.OnItemClickListener {

    private CitiesViewModel viewModel;
    private FragmentCitiesBinding binding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initView();
        setupRecyclerView();

        return view;
    }

    private void navigateToWeatherDetails(City city) {
        CitiesFragmentDirections.ActionWeatherDetails action = CitiesFragmentDirections.actionWeatherDetails().setCity(city);
        Navigation.findNavController(view).navigate(action);
    }

    private void initView() {
        binding = FragmentCitiesBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(CitiesViewModel.class);
        view = binding.getRoot();

        showSmallestTemp();
    }

    private void showSmallestTemp() {
        String smallestTemp = getString(R.string.smallest_temp) + ": " + viewModel.getSmallestTemp();
        binding.smallestTemp.setText(smallestTemp);
    }

    private void setupRecyclerView() {
        List<City> cityList = viewModel.getConvertedCityList();
        CitiesAdapter citiesAdapter = new CitiesAdapter(cityList, this);
        binding.cities.setAdapter(citiesAdapter);
        binding.cities.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.cities.setHasFixedSize(true);
        binding.cities.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onItemClick(City city) {
        navigateToWeatherDetails(city);
    }
}