package com.mobdeve.s18.group16.delacruz_dizon.space_travelers.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.R;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.SetupActivity;
import com.mobdeve.s18.group16.delacruz_dizon.space_travelers.model.Block;

import java.util.ArrayList;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder>{
    private ArrayList<String> mapName;
    private Context context;

    public ButtonAdapter(ArrayList<String> mapName, Context context) {

        //this.buttonList = buttonList;
        this.mapName = mapName;
        this.context = context;
    }

    public void addButtons (ArrayList<Block> buttonList) {
        buttonList.clear();
        buttonList.addAll(buttonList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mapName.size();
    }

    public ButtonAdapter.ButtonViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_choose, parent, false);

        ButtonViewHolder buttonViewHolder = new ButtonViewHolder(view);

        buttonViewHolder.btn_choosemap_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = buttonViewHolder.getAdapterPosition();
                Intent intent = new Intent(parent.getContext(), SetupActivity.class  );
                intent.putExtra("mapName",mapName.get(temp));
                parent.getContext().startActivity(intent);

            }
        });
        return buttonViewHolder;
    }

    // watever u want to do sa ui component dito ilalagay
    @Override
    public void onBindViewHolder(ButtonAdapter.ButtonViewHolder holder, int position) {

        holder.btn_choosemap_button.setText(mapName.get(position));



    }

    protected class ButtonViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton btn_choosemap_button;

        public ButtonViewHolder(View view) {
            super(view);
            btn_choosemap_button = view.findViewById(R.id.btn_choosemap_button);

        }
    }
}
