package com.hermanowicz.recruitmenttaskacademyuk.ui.main.cities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hermanowicz.recruitmenttaskacademyuk.R;
import com.hermanowicz.recruitmenttaskacademyuk.databinding.FragmentCitiesBinding;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.adapter.CitiesFullDetailsAdapter;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.adapter.CitiesWithMaxTempAdapter;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.interfaces.OnItemClickListener;
import com.hermanowicz.recruitmenttaskacademyuk.ui.main.model.City;

import java.util.List;

public class CitiesFragment extends Fragment implements OnItemClickListener {

    private CitiesViewModel viewModel;
    private FragmentCitiesBinding binding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        initView();
        setupCitiesRecyclerView();

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

        showSmallestTemps();
    }

    private void showSmallestTemps() {
        String smallestTempAllCities = getString(R.string.smallest_temp_all_cities) + " = " + viewModel.getSmallestTempAllCities();
        binding.smallestTempAllCities.setText(smallestTempAllCities);

        String smallestTempDaily = getString(R.string.smallest_temp_daily) + " ≈ " + viewModel.getSmallestDailyTemp();
        binding.smallestTempDaily.setText(smallestTempDaily);
    }

    private void setupCitiesRecyclerView() {
        RecyclerView citiesTaskTwo = binding.citiesTaskTwo;
        List<City> cityList = viewModel.getConvertedCityList();
        CitiesWithMaxTempAdapter citiesWithMaxTempAdapter = new CitiesWithMaxTempAdapter(cityList, this);

        citiesTaskTwo.setAdapter(citiesWithMaxTempAdapter);
        citiesTaskTwo.setLayoutManager(new LinearLayoutManager(getContext()));
        citiesTaskTwo.setHasFixedSize(true);
        citiesTaskTwo.setItemAnimator(new DefaultItemAnimator());

        RecyclerView citiesTaskThree = binding.citiesTaskFour;
        CitiesFullDetailsAdapter citiesFullDetailsAdapter = new CitiesFullDetailsAdapter(cityList, this);

        citiesTaskThree.setAdapter(citiesFullDetailsAdapter);
        citiesTaskThree.setLayoutManager(new LinearLayoutManager(getContext()));
        citiesTaskThree.setHasFixedSize(true);
        citiesTaskThree.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onItemClick(City city) {
        navigateToWeatherDetails(city);
    }
}