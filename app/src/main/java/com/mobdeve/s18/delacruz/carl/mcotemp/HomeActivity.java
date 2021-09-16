package com.mobdeve.s18.delacruz.carl.mcotemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityHomeBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.services.MusicService;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        startService(new Intent(this, MusicService.class));

        binding.btnHomeCreatemap.setOnClickListener(v -> {
            Intent gotoCreateMap = new Intent(getApplicationContext(), CreatemapActivity.class);
            startActivity(gotoCreateMap);
        });

        binding.btnHomePlay.setOnClickListener(v ->{
            Intent gotoChoosemap = new Intent(getApplicationContext(), ChooseMapActivity.class);
            startActivity(gotoChoosemap);
        });
        binding.btnHomeSettings.setOnClickListener(v->{
            Intent gotoSettings = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(gotoSettings);
        });

    }
}