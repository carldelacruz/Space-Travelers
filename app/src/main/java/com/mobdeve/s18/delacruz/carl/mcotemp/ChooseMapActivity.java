package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.mobdeve.s18.delacruz.carl.mcotemp.DAO.DAOSQLImpl;
import com.mobdeve.s18.delacruz.carl.mcotemp.adapter.ButtonAdapter;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityChoosemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;

import java.util.ArrayList;

public class ChooseMapActivity extends AppCompatActivity {
    private ActivityChoosemapBinding binding;
    private ArrayList<Block> buttonList;
    private ButtonAdapter buttonAdapter;
    DAOSQLImpl database = new DAOSQLImpl(this);



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
        buttonList = database.getBlocks();

        buttonAdapter = new ButtonAdapter(buttonList, getApplicationContext());

        binding.rvButtons.setLayoutManager(new GridLayoutManager(getApplicationContext(),5));
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
