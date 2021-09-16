package com.mobdeve.s18.delacruz.carl.mcotemp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s18.delacruz.carl.mcotemp.R;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>{
    private ArrayList<Block> buttonList ;
    private Context context;

    public ButtonAdapter(ArrayList<Block> buttonList, Context context) {
        this.buttonList = buttonList;
        this.context = context;
    }

    public void addButtons (ArrayList<Block> buttonList) {
        buttonList.clear();
        buttonList.addAll(buttonList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return buttonList.size();
    }

    public ButtonAdapter.ButtonViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_choose, parent, false);

        ButtonAdapter.ButtonViewHolder buttonViewHolder = new ButtonAdapter.ButtonViewHolder(view);
        return buttonViewHolder;
    }

    // watever u want to do sa ui component dito ilalagay
    @Override
    public void onBindViewHolder(ButtonAdapter.ButtonViewHolder holder, int position) {
        HashSet<String> hset;
            hset= new HashSet<String>(Collections.singleton(buttonList.get(position).getMapName()));

        String[] mapnames = hset.toArray(new String[hset.size()]);
        for(int i=0;i<mapnames.length;i++){
                holder.btn_choosemap_button.setText(mapnames[i]);
        }


    }

    protected class ButtonViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton btn_choosemap_button;

        public ButtonViewHolder(View view) {
            super(view);
            btn_choosemap_button = view.findViewById(R.id.btn_choosemap_button);

        }
    }
}
