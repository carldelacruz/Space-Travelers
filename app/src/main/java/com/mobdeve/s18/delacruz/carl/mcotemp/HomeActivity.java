package com.mobdeve.s18.delacruz.carl.mcotemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnHomeCreatemap.setOnClickListener(v -> {
            Intent gotoCreateMap = new Intent(getApplicationContext(), CreatemapActivity.class);
            startActivity(gotoCreateMap);
        });

        binding.btnHomePlay.setOnClickListener(v ->{
            Intent gotoGameplay = new Intent(getApplicationContext(), GameplayActivity.class);
            startActivity(gotoGameplay);
        });

    }
}