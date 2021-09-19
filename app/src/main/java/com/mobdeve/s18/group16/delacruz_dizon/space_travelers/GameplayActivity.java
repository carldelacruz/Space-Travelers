package com.mobdeve.s18.group16.delacruz_dizon.space_travelers;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
            ArrayList<ImageView> imgViewList = new ArrayList<>();

            imgViewList.add(binding.ivGp0);
            imgViewList.add(binding.ivGp1);
            imgViewList.add(binding.ivGp2);
            imgViewList.add(binding.ivGp3);
            imgViewList.add(binding.ivGp4);
            imgViewList.add(binding.ivGp5);
            imgViewList.add(binding.ivGp6);
            imgViewList.add(binding.ivGp7);
            imgViewList.add(binding.ivGp8);
            imgViewList.add(binding.ivGp9);
            imgViewList.add(binding.ivGp10);
            imgViewList.add(binding.ivGp11);
            imgViewList.add(binding.ivGp12);
            imgViewList.add(binding.ivGp13);
            imgViewList.add(binding.ivGp14);
            imgViewList.add(binding.ivGp15);
            imgViewList.add(binding.ivGp16);
            imgViewList.add(binding.ivGp17);
            imgViewList.add(binding.ivGp18);
            imgViewList.add(binding.ivGp19);
            imgViewList.add(binding.ivGp20);
            imgViewList.add(binding.ivGp21);
            imgViewList.add(binding.ivGp22);
            imgViewList.add(binding.ivGp23);
            imgViewList.add(binding.ivGp24);
            imgViewList.add(binding.ivGp25);
            imgViewList.add(binding.ivGp26);
            imgViewList.add(binding.ivGp27);
            imgViewList.add(binding.ivGp28);
            imgViewList.add(binding.ivGp29);

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

        Button btngp0 = (Button)findViewById(R.id.btn_gameplay_0);
        Button btngp1 = (Button)findViewById(R.id.btn_gameplay_1);
        Button btngp2 = (Button)findViewById(R.id.btn_gameplay_2);
        Button btngp3 = (Button)findViewById(R.id.btn_gameplay_3);
        Button btngp4 = (Button)findViewById(R.id.btn_gameplay_4);
        Button btngp5 = (Button)findViewById(R.id.btn_gameplay_5);
        Button btngp6 = (Button)findViewById(R.id.btn_gameplay_6);
        Button btngp7 = (Button)findViewById(R.id.btn_gameplay_7);
        Button btngp8 = (Button)findViewById(R.id.btn_gameplay_8);
        Button btngp9 = (Button)findViewById(R.id.btn_gameplay_9);
        Button btngp10 = (Button)findViewById(R.id.btn_gameplay_10);
        Button btngp11 = (Button)findViewById(R.id.btn_gameplay_11);
        Button btngp12 = (Button)findViewById(R.id.btn_gameplay_12);
        Button btngp13 = (Button)findViewById(R.id.btn_gameplay_13);
        Button btngp14 = (Button)findViewById(R.id.btn_gameplay_14);
        Button btngp15 = (Button)findViewById(R.id.btn_gameplay_15);
        Button btngp16 = (Button)findViewById(R.id.btn_gameplay_16);
        Button btngp17 = (Button)findViewById(R.id.btn_gameplay_17);
        Button btngp18 = (Button)findViewById(R.id.btn_gameplay_18);
        Button btngp19 = (Button)findViewById(R.id.btn_gameplay_19);
        Button btngp20 = (Button)findViewById(R.id.btn_gameplay_20);
        Button btngp21 = (Button)findViewById(R.id.btn_gameplay_21);
        Button btngp22 = (Button)findViewById(R.id.btn_gameplay_22);
        Button btngp23 = (Button)findViewById(R.id.btn_gameplay_23);
        Button btngp24 = (Button)findViewById(R.id.btn_gameplay_24);
        Button btngp25 = (Button)findViewById(R.id.btn_gameplay_25);
        Button btngp26 = (Button)findViewById(R.id.btn_gameplay_26);
        Button btngp27 = (Button)findViewById(R.id.btn_gameplay_27);
        Button btngp28 = (Button)findViewById(R.id.btn_gameplay_28);
        Button btngp29 = (Button)findViewById(R.id.btn_gameplay_29);

        for(int i=0;i<blockList.size();i++){
            if(mapName.equals(blockList.get(i).getMapName())){
                if(0==blockList.get(i).getBlockNum()){
                    btngp0.setText(setTextb(blockList.get(i)));
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
