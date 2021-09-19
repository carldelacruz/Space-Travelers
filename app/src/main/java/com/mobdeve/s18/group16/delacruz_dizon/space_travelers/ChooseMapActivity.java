package com.mobdeve.s18.group16.delacruz_dizon.space_travelers;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.DAO.DAOSQLImpl;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.adapter.ButtonAdapter;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.databinding.ActivityChoosemapBinding;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.model.Block;

import java.util.ArrayList;
import java.util.List;

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
        if (isApplicationSentToBackground(this)){
            HomeActivity.musicService.pauseMusic();
        }
        Log.d("Life Cycle","Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(HomeActivity.musicIntent);
    }

    // checks if application is sent to background
    public boolean isApplicationSentToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }
}
