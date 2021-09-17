package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityGameplayBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivitySettingsBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.services.MusicService;

import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    private ActivitySettingsBinding binding;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar seekbar = findViewById(R.id.sb_background_music);
        seekbar.setMax(maxVol);
        seekbar.setProgress(curVol);


        binding.sbBackgroundMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        binding.btnSettingsBack.setOnClickListener(v -> {
            Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(gotoHome);
        });
    }

}
