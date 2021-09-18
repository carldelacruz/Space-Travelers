package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobdeve.s18.delacruz.carl.mcotemp.DAO.DAOSQLImpl;
import com.mobdeve.s18.delacruz.carl.mcotemp.adapter.BlockAdapter;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityCreatemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityGameplayBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;

import java.util.ArrayList;
import java.util.Random;

public class GameplayActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityGameplayBinding binding;
    final int min = 1;
    final int max = 6;
    final int random = new Random().nextInt((max - min) + 1) + min;
    int x = 1;
    private ArrayList<Block> blockList;
    DAOSQLImpl database = new DAOSQLImpl(this);
    private BlockAdapter blockAdapter;
    String mapName;
    int ai;
    int player;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameplayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        mapName = intent.getStringExtra("mapName");
        player = intent.getIntExtra("player",-1);
        ai = intent.getIntExtra("ai",-1);
        blockList = database.getBlocks();
        blockAdapter = new BlockAdapter(blockList,getApplicationContext(),mapName);
        binding.rvDatalist.setLayoutManager(new GridLayoutManager(getApplicationContext(),5));
        binding.rvDatalist.setAdapter(blockAdapter);




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
