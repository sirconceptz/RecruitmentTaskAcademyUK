package com.hermanowicz.recruitmenttaskacademyuk.ui.main.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hermanowicz.recruitmenttaskacademyuk.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}