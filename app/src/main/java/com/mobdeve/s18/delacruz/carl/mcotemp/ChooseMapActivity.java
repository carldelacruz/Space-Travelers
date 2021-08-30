package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityChoosemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityHomeBinding;

public class ChooseMapActivity extends AppCompatActivity {
    private ActivityChoosemapBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityChoosemapBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnChoosemapBack.setOnClickListener(v -> {
            Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(gotoHome);
        });
        binding.btnChoosemapChoose.setOnClickListener(v -> {
            Intent gotoSetup = new Intent(getApplicationContext(), SetupActivity.class);
            startActivity(gotoSetup);
        });
    }
}
