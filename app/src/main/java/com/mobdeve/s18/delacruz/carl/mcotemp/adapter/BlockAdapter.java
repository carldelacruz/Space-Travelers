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

    public BlockAdapter(ArrayList<Block> BlockList, Context context) {
        this.blockList = BlockList;
        this.context = context;
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
        for(int i = 0; i < blockList.size(); i++) {
            if (blockList.get(i).getMapName() == "");
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
