package com.mobdeve.s18.group16.delacruz_dizon.space_travelers.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.R;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.model.Block;

import java.util.ArrayList;

public class BlockAdapter extends RecyclerView.Adapter<BlockAdapter.BlockViewHolder>{
    private ArrayList<Block> blockList;
    private Context context;
    private String mapName;

    public BlockAdapter(ArrayList<Block> BlockList, Context context, String mapName) {
        this.blockList = BlockList;
        this.context = context;
        this.mapName = mapName;
    }

    public void addBlocks (ArrayList<Block> blocksList) {
        blockList.clear();
        blockList.addAll(blocksList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return blockList.size();
    }

    public BlockAdapter.BlockViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.block_data, parent, false);

        BlockViewHolder blockViewHolder = new BlockViewHolder(view);
        return blockViewHolder;
    }

    // watever u want to do sa ui component dito ilalagay
    @Override
    public void onBindViewHolder(BlockAdapter.BlockViewHolder holder, int position) {
        int max= 30;


        ArrayList<Block> playMap= new ArrayList<>();

        if (blockList.get(position).getMapName() == mapName){
            playMap.add(blockList.get(position));
        }


        for(int i = 0; i<playMap.size();i++){
            switch(playMap.get(i).getBlockType()){

                case 1: holder.btn_block.setText("T");
                    connect(playMap,i,holder);
                    Log.i("Recycler View", "PUMAPASOKKKKKK**********");
                    break;
                case 2: holder.btn_block.setText("B");
                    connect(playMap,i,holder);
                    break;
                case 3: holder.btn_block.setText("I");
                    connect(playMap,i,holder);
                    break;
                case 4: holder.btn_block.setText("D");
                    connect(playMap,i,holder);
                    break;
                default: holder.btn_block.setText(String.valueOf(playMap.get(i).getBlockNum()));
            }

        }


    }
    public void connect(ArrayList<Block> playMap,int position, BlockViewHolder holder){
        for(int i =0;i<playMap.size();i++){

            if(playMap.get(position).getpBlockNum()==playMap.get(i).getBlockNum()){

                switch (playMap.get(position).getBlockType()) {

                    case 1: holder.btn_block.setText("T");
                        break;

                    case 2: holder.btn_block.setText("B");
                        break;

                    case 3: holder.btn_block.setText("I");
                        break;

                    case 4: holder.btn_block.setText("D");
                        break;

                }
            }

        }
    }

    protected class BlockViewHolder extends RecyclerView.ViewHolder {
        Button btn_block;

        public BlockViewHolder(View view) {
            super(view);
            btn_block = view.findViewById(R.id.btn_block);

        }
    }
}
