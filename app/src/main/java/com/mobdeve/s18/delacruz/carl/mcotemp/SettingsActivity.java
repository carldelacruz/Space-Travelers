package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityGameplayBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivitySettingsBinding;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySettingsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSettingsBack.setOnClickListener(v -> {
            Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(gotoHome);
        });
    }
    @Override
    public void onClick(View v) {

    }
}
