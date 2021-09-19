package com.mobdeve.s18.group16.delacruz_dizon.space_travelers.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.R;

public class MusicService extends Service {

    private MediaPlayer player;
    private int length;

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.backgroundmusic);
        player.setLooping(true);
        player.setVolume(50,50);
        Log.d("Service MusicService","onCreate Initialize");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        player.start();
        Log.d("Service MusicService","onStartCommand Play");
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
        Log.d("Service MusicService","onDestroy Stop");
    }

    public void pauseMusic() {
        if(player.isPlaying()) {
            player.pause();
            length = player.getCurrentPosition();
        }
        Log.d("STATUS", "pauseMusic");
    }

    public void resumeMusic()
    {
        if(player.isPlaying()==false) {
            player.seekTo(length);
            player.start();
        }
        Log.d("STATUS", "resumeMusic");
    }

    public void stopMusic() {
        player.stop();
        player.release();
        player = null;
        Log.d("STATUS", "stopMusic");
    }

    //(x) Binding related code
    private final IBinder binder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class LocalBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }
}
