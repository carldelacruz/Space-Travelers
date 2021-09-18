package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityChoosemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivitySetuppageBinding;

public class SetupActivity extends AppCompatActivity {
    private ActivitySetuppageBinding binding;
    private int player=0;
    private int ai= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivitySetuppageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        String mapName1 = intent.getStringExtra("mapName");
        Intent gotoGameplay = new Intent(getApplicationContext(), GameplayActivity.class);
        binding.tvSetuppageMapname.setText(mapName1);

        binding.btnSetuppageBack.setOnClickListener(v -> {
            Intent gotoChoosemap = new Intent(getApplicationContext(), ChooseMapActivity.class);
            startActivity(gotoChoosemap);
        });
        binding.btnSetuppageAi1.setOnClickListener(v -> {
            ai=1;
            player=0;
        });
        binding.btnSetuppageAi2.setOnClickListener(v -> {
            ai=2;
            player=0;
        });
        binding.btnSetuppageAi3.setOnClickListener(v -> {
            ai=3;
            player=0;
        });
        binding.btnSetuppageMp1.setOnClickListener(v -> {
            player=1;
            ai=0;
        });
        binding.btnSetuppageMp2.setOnClickListener(v -> {
            player=2;
            ai=0;
        });
        binding.btnSetuppageMp3.setOnClickListener(v -> {
            player=3;
            ai=0;
        });
        binding.btnSetuppagePlay.setOnClickListener(v -> {
            gotoGameplay.putExtra("mapName",mapName1);
            gotoGameplay.putExtra("ai", ai);
            gotoGameplay.putExtra("player", player);
            startActivity(gotoGameplay);
        });
    }
}
