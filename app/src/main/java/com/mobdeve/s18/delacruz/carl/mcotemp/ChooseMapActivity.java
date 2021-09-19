package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobdeve.s18.delacruz.carl.mcotemp.DAO.DAOSQLImpl;
import com.mobdeve.s18.delacruz.carl.mcotemp.adapter.ButtonAdapter;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityChoosemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ChooseMapActivity extends AppCompatActivity {
    private ActivityChoosemapBinding binding;
    private ArrayList<Block> buttonList;
    private ButtonAdapter buttonAdapter;
    DAOSQLImpl database = new DAOSQLImpl(this);
    private ArrayList<String> mapNames = new ArrayList<>();




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
    }

    @Override
    protected void onStart() {
        super.onStart();
        String temp ="";
        buttonList = database.getBlocks();

        ArrayList<String> hset = new ArrayList<>();

        for(int i=0;i<buttonList.size();i++){
            if(!buttonList.get(i).getMapName().equals(temp)){
                hset.add(buttonList.get(i).getMapName());
                temp = buttonList.get(i).getMapName();
                Log.i("Recycler View",buttonList.get(i).getMapName());
            }
        }


        mapNames = hset;
        for(int i=0;i<mapNames.size();i++){
            Log.i("Recycler View",mapNames.get(i));

        }


        buttonAdapter = new ButtonAdapter(mapNames, getApplicationContext());

        buttonAdapter.notifyDataSetChanged();
        binding.rvButtons.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.rvButtons.setAdapter(buttonAdapter);

        Log.d("Life Cycle","Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        Log.d("Life Cycle","Pause");

    }
}
