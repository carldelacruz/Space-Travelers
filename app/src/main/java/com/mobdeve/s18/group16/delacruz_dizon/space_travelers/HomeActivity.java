package com.mobdeve.s18.group16.delacruz_dizon.space_travelers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.databinding.ActivityHomeBinding;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.services.MusicService;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    private boolean bound;
    public static MusicService musicService;
    public static Intent musicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnHomeCreatemap.setOnClickListener(v -> {
            Intent gotoCreateMap = new Intent(getApplicationContext(), CreatemapActivity.class);
            startActivity(gotoCreateMap);
        });

        binding.btnHomePlay.setOnClickListener(v ->{
            Intent gotoChoosemap = new Intent(getApplicationContext(), ChooseMapActivity.class);
            startActivity(gotoChoosemap);
        });

        binding.btnHomeSettings.setOnClickListener(v->{
            Intent gotoSettings = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(gotoSettings);
        });

        binding.btnHomeExitgame.setOnClickListener(v -> {
            finish();
        });

        musicIntent = new Intent(this, MusicService.class);
        musicService = new MusicService();

        startService(musicIntent);
        if(!bound)
            bindService(musicIntent, mConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(bound)
            unbindService(mConnection);
        stopService(musicIntent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        startService(musicIntent);
    }

    @Override
    public void onPause() {
        // check if app went to home
        if (isApplicationSentToBackground(this)){
            musicService.pauseMusic();
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

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            MusicService.LocalBinder binder = (MusicService.LocalBinder) service;
            musicService = (binder.getService());
            bound = true;
            Log.d(" - SERVICE","ServiceConnection made");
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            bound = false;
        }
    };
}