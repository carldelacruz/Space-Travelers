package com.mobdeve.s18.group16.delacruz_dizon.space_travelers;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.DAO.DAOSQLImpl;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.databinding.ActivityCreatemapBinding;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.databinding.ActivityGameplayBinding;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.model.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameplayActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityGameplayBinding binding;
    final int min = 1;
    final int max = 6;
    final int random = new Random().nextInt((max - min) + 1) + min;
    int turn = 0;
    private ArrayList<Block> blockList;
    DAOSQLImpl database = new DAOSQLImpl(this);
    String mapName;
    int ai;
    int player;
    Integer[] playerPlaces = {0,0,0,0};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameplayBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);



        binding.btnGameplayQuit.setOnClickListener(v -> {
            Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(gotoHome);
        });

        binding.btnGpRoll.setOnClickListener(v -> {
            final int random = new Random().nextInt((max - min) + 1) + min;
            TextView tvRoll = (TextView)findViewById(R.id.tv_roll_val);
            tvRoll.setText(String.valueOf(random));
            ImageView player = (ImageView)findViewById(R.id.iv_gp_icon);

            if(turn==0){
                player.setImageResource(R.drawable.sample2);
                playerPlaces[turn]=random+playerPlaces[turn];
                turn=1;
            }
            else if(turn==1){
                player.setImageResource(R.drawable.sample3);
                playerPlaces[turn]=random+playerPlaces[turn];
                turn=2;
            }
            else if(turn==2){
                player.setImageResource(R.drawable.sample4);
                playerPlaces[turn]=random+playerPlaces[turn];

                turn=3;
            }
            else if(turn==3){
                player.setImageResource(R.drawable.sample1);
                playerPlaces[turn]=random+playerPlaces[turn];
                turn=0;
            }



        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        mapName = intent.getStringExtra("mapName");
        TextView map = (TextView)findViewById(R.id.tv_gameplay_mapname);
        map.setText(mapName);
        player = intent.getIntExtra("player",-1);
        ai = intent.getIntExtra("ai",-1);
        blockList = database.getBlocks();

        ArrayList<ImageButton> btngp= new ArrayList<>();

        btngp.add(binding.btnGameplay0);
        btngp.add(binding.btnGameplay1);
        btngp.add(binding.btnGameplay2);
        btngp.add(binding.btnGameplay3);
        btngp.add(binding.btnGameplay4);
        btngp.add(binding.btnGameplay5);
        btngp.add(binding.btnGameplay6);
        btngp.add(binding.btnGameplay7);
        btngp.add(binding.btnGameplay8);
        btngp.add(binding.btnGameplay9);
        btngp.add(binding.btnGameplay10);
        btngp.add(binding.btnGameplay11);
        btngp.add(binding.btnGameplay12);
        btngp.add(binding.btnGameplay13);
        btngp.add(binding.btnGameplay14);
        btngp.add(binding.btnGameplay15);
        btngp.add(binding.btnGameplay16);
        btngp.add(binding.btnGameplay17);
        btngp.add(binding.btnGameplay18);
        btngp.add(binding.btnGameplay19);
        btngp.add(binding.btnGameplay20);
        btngp.add(binding.btnGameplay21);
        btngp.add(binding.btnGameplay22);
        btngp.add(binding.btnGameplay23);
        btngp.add(binding.btnGameplay24);
        btngp.add(binding.btnGameplay25);
        btngp.add(binding.btnGameplay26);
        btngp.add(binding.btnGameplay27);
        btngp.add(binding.btnGameplay28);
        btngp.add(binding.btnGameplay29);



        for(int i=0;i<blockList.size();i++) {
            if(mapName.equals(blockList.get(i).getMapName())){
                for (int j = 0; j < btngp.size(); j++) {
                    if(j==blockList.get(i).getBlockNum()){
                        btngp.get(j).set
                    }
                }
            }
        }
                if(0==blockList.get(i).getBlockNum()){
                    .setText(setTextb(blockList.get(i)));
                }
                if(1==blockList.get(i).getBlockNum()){
                    btngp1.setText(setTextb(blockList.get(i)));
                }
                if(2==blockList.get(i).getBlockNum()){
                    btngp2.setText(setTextb(blockList.get(i)));
                }
                if(3==blockList.get(i).getBlockNum()){
                    btngp3.setText(setTextb(blockList.get(i)));
                }
                if(4==blockList.get(i).getBlockNum()){
                    btngp4.setText(setTextb(blockList.get(i)));
                }
                if(5==blockList.get(i).getBlockNum()){
                    btngp5.setText(setTextb(blockList.get(i)));
                }
                if(6==blockList.get(i).getBlockNum()){
                    btngp6.setText(setTextb(blockList.get(i)));
                }
                if(7==blockList.get(i).getBlockNum()){
                    btngp7.setText(setTextb(blockList.get(i)));
                }
                if(8==blockList.get(i).getBlockNum()){
                    btngp8.setText(setTextb(blockList.get(i)));
                }
                if(9==blockList.get(i).getBlockNum()){
                    btngp9.setText(setTextb(blockList.get(i)));
                }
                if(10==blockList.get(i).getBlockNum()){
                    btngp10.setText(setTextb(blockList.get(i)));
                }
                if(11==blockList.get(i).getBlockNum()){
                    btngp11.setText(setTextb(blockList.get(i)));
                }
                if(12==blockList.get(i).getBlockNum()){
                    btngp12.setText(setTextb(blockList.get(i)));
                }
                if(13==blockList.get(i).getBlockNum()){
                    btngp13.setText(setTextb(blockList.get(i)));
                }
                if(14==blockList.get(i).getBlockNum()){
                    btngp14.setText(setTextb(blockList.get(i)));
                }
                if(15==blockList.get(i).getBlockNum()){
                    btngp15.setText(setTextb(blockList.get(i)));
                }
                if(16==blockList.get(i).getBlockNum()){
                    btngp16.setText(setTextb(blockList.get(i)));
                }
                if(17==blockList.get(i).getBlockNum()){
                    btngp17.setText(setTextb(blockList.get(i)));
                }
                if(18==blockList.get(i).getBlockNum()){
                    btngp18.setText(setTextb(blockList.get(i)));
                }
                if(19==blockList.get(i).getBlockNum()){
                    btngp19.setText(setTextb(blockList.get(i)));
                }
                if(20==blockList.get(i).getBlockNum()){
                    btngp20.setText(setTextb(blockList.get(i)));
                }
                if(21==blockList.get(i).getBlockNum()){
                    btngp21.setText(setTextb(blockList.get(i)));
                }
                if(22==blockList.get(i).getBlockNum()){
                    btngp22.setText(setTextb(blockList.get(i)));
                }
                if(23==blockList.get(i).getBlockNum()){
                    btngp23.setText(setTextb(blockList.get(i)));
                }
                if(24==blockList.get(i).getBlockNum()){
                    btngp24.setText(setTextb(blockList.get(i)));
                }
                if(25==blockList.get(i).getBlockNum()){
                    btngp25.setText(setTextb(blockList.get(i)));
                }
                if(26==blockList.get(i).getBlockNum()){
                    btngp26.setText(setTextb(blockList.get(i)));
                }
                if(27==blockList.get(i).getBlockNum()){
                    btngp27.setText(setTextb(blockList.get(i)));
                }
                if(28==blockList.get(i).getBlockNum()){
                    btngp28.setText(setTextb(blockList.get(i)));
                }
                if(29==blockList.get(i).getBlockNum()){
                    btngp29.setText(setTextb(blockList.get(i)));
                }

            }


    


    public String setTextb(Block block){

        switch(block.getBlockType()){
            case 1: return "T";
            case 2: return "B";
            case 3: return "I";
            case 4: return "D";
            default:
                return String.valueOf(block.getBlockNum());
        }

    }


    @Override
    public void onClick(View v) {

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