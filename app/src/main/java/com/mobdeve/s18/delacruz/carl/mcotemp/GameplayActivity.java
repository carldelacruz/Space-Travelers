package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityCreatemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityGameplayBinding;

import java.util.ArrayList;
import java.util.Random;

public class GameplayActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityGameplayBinding binding;
    final int min = 1;
    final int max = 6;
    final int random = new Random().nextInt((max - min) + 1) + min;
    int x = 1;
    private ArrayList<Tile> tileArrayList;
    private TileAdapter tileAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameplayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        tileArrayList = new DataHelper().initializeData();
        tileAdapter = new TileAdapter(getApplicationContext(), tileArrayList);
        binding.rvDatalist.setLayoutManager(new GridLayoutManager(getApplicationContext(),5));

        binding.rvDatalist.setAdapter(tileAdapter);

        binding.btnGameplayQuit.setOnClickListener(v -> {
            Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(gotoHome);
        });

        binding.btnGpRoll.setOnClickListener(v -> {
            final int random = new Random().nextInt((max - min) + 1) + min;
            TextView tvRoll = (TextView)findViewById(R.id.tv_roll_val);
            tvRoll.setText(String.valueOf(random));
            ImageView player = (ImageView)findViewById(R.id.iv_gp_icon);
            if(x==1){
                player.setImageResource(R.drawable.sample2);
                x=2;
            }
            else{
                player.setImageResource(R.drawable.sample);
                x=1;
            }


        });

    }

    @Override
    public void onClick(View v) {

    }
}
