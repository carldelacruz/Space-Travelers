package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityCreatemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;

import java.util.ArrayList;

public class CreatemapActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityCreatemapBinding binding;
    private LayoutInflater layoutInflater;
    private PopupWindow popupWindow;
    private ArrayList<Block> blocks;
    private ArrayList<String> tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreatemapBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCreatemapBack.setOnClickListener(v -> {
            Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(gotoHome);
        });

        binding.btnCreatemap00.setOnClickListener(this);
        binding.btnCreatemap01.setOnClickListener(this);
        binding.btnCreatemap02.setOnClickListener(this);
        binding.btnCreatemap03.setOnClickListener(this);
        binding.btnCreatemap04.setOnClickListener(this);
        binding.btnCreatemap10.setOnClickListener(this);
        binding.btnCreatemap11.setOnClickListener(this);
        binding.btnCreatemap12.setOnClickListener(this);
        binding.btnCreatemap13.setOnClickListener(this);
        binding.btnCreatemap14.setOnClickListener(this);
        binding.btnCreatemap20.setOnClickListener(this);
        binding.btnCreatemap21.setOnClickListener(this);
        binding.btnCreatemap22.setOnClickListener(this);
        binding.btnCreatemap23.setOnClickListener(this);
        binding.btnCreatemap24.setOnClickListener(this);
        binding.btnCreatemap30.setOnClickListener(this);
        binding.btnCreatemap31.setOnClickListener(this);
        binding.btnCreatemap32.setOnClickListener(this);
        binding.btnCreatemap33.setOnClickListener(this);
        binding.btnCreatemap34.setOnClickListener(this);
        binding.btnCreatemap40.setOnClickListener(this);
        binding.btnCreatemap41.setOnClickListener(this);
        binding.btnCreatemap42.setOnClickListener(this);
        binding.btnCreatemap43.setOnClickListener(this);
        binding.btnCreatemap44.setOnClickListener(this);
        binding.btnCreatemap50.setOnClickListener(this);
        binding.btnCreatemap51.setOnClickListener(this);
        binding.btnCreatemap52.setOnClickListener(this);
        binding.btnCreatemap53.setOnClickListener(this);
        binding.btnCreatemap54.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.activity_createmap_popup, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

        //

        // get tag of each button
        switch (v.getId()) {
            case R.id.btn_createmap_00:
                tags.add(binding.btnCreatemap00.getTag().toString());
                break;
            case R.id.btn_createmap_01:
                binding.btnCreatemap01.getTag().toString();
                break;
        }

//        blocks.add(new Block())
    }
}