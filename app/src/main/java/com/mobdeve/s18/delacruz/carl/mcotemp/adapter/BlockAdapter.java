package com.mobdeve.s18.delacruz.carl.mcotemp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s18.delacruz.carl.mcotemp.R;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;

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

        ArrayList<Integer> exclude = new ArrayList<>();

        ArrayList<Block> playMap= new ArrayList<>();

        if (blockList.get(position).getMapName() == mapName){
            playMap.add(blockList.get(position));
        }

        int numNormalblocks = max-playMap.size();
        exclude.add(playMap.get(position).getBlockNum());

        for(int i = 0; i<numNormalblocks;i++){
            for(int j = 0;j<exclude.size();j++){
                if(exclude.get(j)!=playMap.get(i).getBlockNum())
                    playMap.add(new Block());
            }
        }


        switch(playMap.get(position).getBlockType()){

            case 1: holder.btn_block.setText("T");
            break;
            case 2: holder.btn_block.setText("B");
            break;
            case 3: holder.btn_block.setText("I");
            break;
            case 4: holder.btn_block.setText("D");
            break;
            default: holder.btn_block.setText(playMap.get(position).getBlockNum());
        }




    }
    public void connect(Block temp){
        switch (temp.getpBlockNum())
    }

    protected class BlockViewHolder extends RecyclerView.ViewHolder {
        Button btn_block;

        public BlockViewHolder(View view) {
            super(view);
            btn_block = view.findViewById(R.id.btn_block);

        }
    }
}
