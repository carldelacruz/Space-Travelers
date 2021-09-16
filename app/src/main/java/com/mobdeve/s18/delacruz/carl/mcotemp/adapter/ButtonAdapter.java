package com.mobdeve.s18.delacruz.carl.mcotemp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s18.delacruz.carl.mcotemp.R;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;

import java.util.ArrayList;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>{
    private ArrayList<Button> buttonList;
    private Context context;

    public ButtonAdapter(ArrayList<Button> ButtonList, Context context) {
        this.buttonList = ButtonList;
        this.context = context;
    }

    public void addBlocks (ArrayList<Block> blocksList) {
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
                .inflate(R.layout.block_data, parent, false);

        ButtonAdapter.ButtonViewHolder buttonViewHolder = new ButtonAdapter.ButtonViewHolder(view);
        return buttonViewHolder;
    }

    // watever u want to do sa ui component dito ilalagay
    @Override
    public void onBindViewHolder(ButtonAdapter.ButtonViewHolder holder, int position) {
        holder.btn_choosemap_button.setText(buttonList.get(position).get());
        holder.btn_block.setTag();

    }

    protected class ButtonViewHolder extends RecyclerView.ViewHolder {
        Button btn_choosemap_button;

        public ButtonViewHolder(View view) {
            super(view);
            btn_choosemap_button = view.findViewById(R.id.btn_choosemap_button);

        }
    }
}
