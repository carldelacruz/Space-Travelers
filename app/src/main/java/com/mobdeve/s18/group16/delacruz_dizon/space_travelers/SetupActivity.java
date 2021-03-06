package com.mobdeve.s18.group16.delacruz_dizon.space_travelers;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.databinding.ActivityChoosemapBinding;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.databinding.ActivitySetuppageBinding;

import java.util.List;

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

    @Override
    protected void onResume() {
        super.onResume();
        startService(HomeActivity.musicIntent);
    }

    @Override
    public void onPause() {
        // check if app went to home
        if (isApplicationSentToBackground(this)){
            HomeActivity.musicService.pauseMusic();
        }
        super.onPause();
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
