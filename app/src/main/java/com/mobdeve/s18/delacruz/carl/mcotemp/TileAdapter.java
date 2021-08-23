package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TileAdapter extends RecyclerView.Adapter<TileAdapter.TileViewHolder> {
    ArrayList<Tile> tileArrayList;
    private Context context;

    public TileAdapter(Context context, ArrayList<Tile> tileArrayList){
        this.tileArrayList = tileArrayList;
        this.context = context;
    }

    public TileAdapter.TileViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tile,parent,false);
        TileViewHolder tileViewHolder = new TileViewHolder(view);

        return tileViewHolder;
    }

    @Override
    public void onBindViewHolder(TileAdapter.TileViewHolder holder, int position) {

        holder.icon.setImageResource(tileArrayList.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return tileArrayList.size();
    }


    class TileViewHolder extends RecyclerView.ViewHolder{
        ImageView icon;

        public TileViewHolder(View view){
            super(view);
            icon = view.findViewById(R.id.iv_at_icon);

        }
    }
}
