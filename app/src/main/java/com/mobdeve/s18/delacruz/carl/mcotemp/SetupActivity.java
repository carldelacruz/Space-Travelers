package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityChoosemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivitySetuppageBinding;

public class SetupActivity extends AppCompatActivity {
    private ActivitySetuppageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivitySetuppageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSetuppageBack.setOnClickListener(v -> {
            Intent gotoChoosemap = new Intent(getApplicationContext(), ChooseMapActivity.class);
            startActivity(gotoChoosemap);
        });
        binding.btnSetuppagePlay.setOnClickListener(v -> {
            Intent gotoGameplay = new Intent(getApplicationContext(), GameplayActivity.class);
            startActivity(gotoGameplay);
        });
    }
}
