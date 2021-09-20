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
    int[] playerPlaces = {0,0,0,0};




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
                        btngp.get(j).setTag(blockList.get(i).getBlockNum());
                        if(blockList.get(i).getBlockType()==1){
                            btngp.get(j).setImageResource(R.drawable.teleporter);
                        }else if(blockList.get(i).getBlockType()==4){
                            btngp.get(j).setImageResource(R.drawable.disable);
                        }
                    }
                }
            }
        }
        binding.btnGpRoll.setOnClickListener(v -> {
            final int random = new Random().nextInt((max - min) + 1) + min;
            TextView tvRoll = (TextView)findViewById(R.id.tv_roll_val);
            tvRoll.setText(String.valueOf(random));
            ImageView player = (ImageView)findViewById(R.id.iv_gp_icon);

            if(turn==0){
                player.setImageResource(R.drawable.sample2);
                moveMechanicsb(turn,playerPlaces,btngp);
                moveMechanicsa(turn,playerPlaces,btngp,blockList,random);
                turn=1;
            }
            else if(turn==1){
                player.setImageResource(R.drawable.sample3);
                moveMechanicsb(turn,playerPlaces,btngp);
                moveMechanicsa(turn,playerPlaces,btngp,blockList,random);

                turn=2;
            }
            else if(turn==2){
                player.setImageResource(R.drawable.sample4);
                moveMechanicsb(turn,playerPlaces,btngp);
                moveMechanicsa(turn,playerPlaces,btngp,blockList,random);

                turn=3;
            }
            else if(turn==3){
                player.setImageResource(R.drawable.sample1);
                moveMechanicsb(turn,playerPlaces,btngp);
                moveMechanicsa(turn,playerPlaces,btngp,blockList,random);

                turn=0;
            }
        });

    }
    public void moveMechanicsb(int turn, int[] playerPlaces,ArrayList<ImageButton> btngp){
        switch (turn){
            case 0: if(playerPlaces[0]==playerPlaces[1]||playerPlaces[0]==playerPlaces[2]||playerPlaces[0]==playerPlaces[3]){ }
            else{btngp.get(playerPlaces[0]).setImageResource(R.drawable.tile);}
            break;
            case 1: if(playerPlaces[1]==playerPlaces[0]||playerPlaces[1]==playerPlaces[2]||playerPlaces[1]==playerPlaces[3]){ }
            else{btngp.get(playerPlaces[1]).setImageResource(R.drawable.tile);}
                break;
            case 2: if(playerPlaces[2]==playerPlaces[0]||playerPlaces[2]==playerPlaces[1]||playerPlaces[2]==playerPlaces[3]){ }
            else{btngp.get(playerPlaces[2]).setImageResource(R.drawable.tile);}
                break;
            case 3: if(playerPlaces[3]==playerPlaces[0]||playerPlaces[3]==playerPlaces[1]||playerPlaces[3]==playerPlaces[2]){ }
            else{btngp.get(playerPlaces[3]).setImageResource(R.drawable.tile);}
                break;
        }
    }
    public void moveMechanicsa(int turn, int[] playerPlaces, ArrayList<ImageButton> btngp, ArrayList<Block> blocklist, int random){
        int x=0;
        switch (turn){
            case 0: playerPlaces[turn]=random+playerPlaces[turn];
                if(playerPlaces[turn]>=29){
                    playerPlaces[turn]=29;
                }
                for(int i=0;i<blocklist.size();i++){
                    if(btngp.get(playerPlaces[turn]).getTag().equals(blocklist.get(i).getBlockNum())&& blocklist.get(i).getBlockType()==1){
                        if(playerPlaces[turn]<blocklist.get(i).getpBlockNum()){
                            playerPlaces[turn]=blocklist.get(i).getpBlockNum();
                            x=(playerPlaces[turn]-blocklist.get(i).getpBlockNum())+random;
                        }
                        else{
                            x=(blocklist.get(i).getBlockNum());
                            playerPlaces[turn]=blocklist.get(i).getpBlockNum();
                        }
                        btngp.get(x).setImageResource(R.drawable.teleporter);
                    }
                    btngp.get(playerPlaces[turn]).setImageResource(R.drawable.sample1);
                }
                break;
            case 1:playerPlaces[turn]=random+playerPlaces[turn];
                if(playerPlaces[turn]>=29){
                    playerPlaces[turn]=29;
                }
                for(int i=0;i<blocklist.size();i++){
                    if(btngp.get(playerPlaces[turn]).getTag().equals(blocklist.get(i).getBlockNum())&& blocklist.get(i).getBlockType()==1){
                        if(playerPlaces[turn]<blocklist.get(i).getpBlockNum()){
                            playerPlaces[turn]=blocklist.get(i).getpBlockNum();
                            x=(playerPlaces[turn]-blocklist.get(i).getpBlockNum())+random;
                        }
                        else{
                            x=(blocklist.get(i).getBlockNum());
                            playerPlaces[turn]=blocklist.get(i).getpBlockNum();
                        }
                        btngp.get(x).setImageResource(R.drawable.teleporter);
                    }
                    btngp.get(playerPlaces[turn]).setImageResource(R.drawable.sample2);
                }
                break;
            case 2:playerPlaces[turn]=random+playerPlaces[turn];
                if(playerPlaces[turn]>=29){
                    playerPlaces[turn]=29;
                }
                for(int i=0;i<blocklist.size();i++){
                    if(btngp.get(playerPlaces[turn]).getTag().equals(blocklist.get(i).getBlockNum())&& blocklist.get(i).getBlockType()==1){
                        if(playerPlaces[turn]<blocklist.get(i).getpBlockNum()){
                            playerPlaces[turn]=blocklist.get(i).getpBlockNum();
                            x=(playerPlaces[turn]-blocklist.get(i).getpBlockNum())+random;
                        }
                        else{
                            x=(blocklist.get(i).getBlockNum());
                            playerPlaces[turn]=blocklist.get(i).getpBlockNum();
                        }
                        btngp.get(x).setImageResource(R.drawable.teleporter);
                    }
                    btngp.get(playerPlaces[turn]).setImageResource(R.drawable.sample3);
                }
                break;
            case 3:playerPlaces[turn]=random+playerPlaces[turn];
                if(playerPlaces[turn]>=29){
                    playerPlaces[turn]=29;
                }
                for(int i=0;i<blocklist.size();i++){
                    if(btngp.get(playerPlaces[turn]).getTag().equals(blocklist.get(i).getBlockNum())&& blocklist.get(i).getBlockType()==1){
                        if(playerPlaces[turn]<blocklist.get(i).getpBlockNum()){
                            playerPlaces[turn]=blocklist.get(i).getpBlockNum();
                            x=(playerPlaces[turn]-blocklist.get(i).getpBlockNum())+random;
                        }
                        else{
                            x=(blocklist.get(i).getBlockNum());
                            playerPlaces[turn]=blocklist.get(i).getpBlockNum();
                        }
                        btngp.get(x).setImageResource(R.drawable.teleporter);
                    }
                    btngp.get(playerPlaces[turn]).setImageResource(R.drawable.sample4);
                }
                break;

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