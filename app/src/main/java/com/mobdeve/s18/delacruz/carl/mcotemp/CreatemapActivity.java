package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityCreatemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityCreatemapPopupBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Board;

import java.util.ArrayList;

public class CreatemapActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityCreatemapBinding binding;
    private LayoutInflater layoutInflater;
    private ArrayList<Block> blocks = new ArrayList<>();
    private Board board;
    private ArrayList<Button> buttonsGrid = new ArrayList<>();
    private ArrayList<Button> buttonsPopup = new ArrayList<>();
    private String blockCoordinates;
    private String pBlockCoordinates;
    private int x;
    private int y;
    private int px;
    private int py;
    private int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreatemapBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCreatemapBack.setOnClickListener(v -> {
            Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(gotoHome);
        });

        // arraylist of buttons in grid
        initButtonsGrid();


    }

    @Override
    public void onClick(View v) {
        // logic for popup window
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.activity_createmap_popup, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

        // validation, pag wala pa napress na type (teleport, blackhole, immunity, disabled) button
        // wala pa

        // popup window views, teleporter, blackhole, immunity, disabled, next, baguhin ung next line, case to case
        popupView.findViewById(R.id.btn_createmap_popup_teleporter).setOnClickListener(view -> {
            // change background of kung ano mang pinress, next time
            Button tempButton = popupView.findViewById(R.id.btn_createmap_popup_teleporter);
            if (tempButton.isPressed()) {
                Toast.makeText(this, "Teleporter selected", Toast.LENGTH_SHORT).show();
                // next time na ung mag iiba background color, ill ask sir
//                tempButton.setBackgroundColor(getResources().getColor(R.color.gray, null));
            }


            popupView.findViewById(R.id.btn_createmap_popup_next).setOnClickListener(a -> {
                // get text from edit text
                EditText et = popupView.findViewById(R.id.et_createmap_popup_pcoordinate);
                pBlockCoordinates = et.getText().toString();

                // validation, dapat may partner lagi pag maglalagay ng block
                if (pBlockCoordinates.equals("")) {
                    Toast.makeText(this, "PUT A TAIL COORDINATE", Toast.LENGTH_LONG).show();

                } else {
                    // logic for getting the pressed button (blocks)
                    for(int i = 0; i < buttonsGrid.size(); i++) {
                        if(v.getId() == buttonsGrid.get(i).getId()) {
                            // get details of button (coordinates, type)
                            blockCoordinates = buttonsGrid.get(i).getTag().toString();
                            x = Integer.parseInt(blockCoordinates.substring(0, 1));
                            y = Integer.parseInt(blockCoordinates.substring(1));

                            // get coordinate of partner

                            px = Integer.parseInt(pBlockCoordinates.substring(0, 1));
                            py = Integer.parseInt(pBlockCoordinates.substring(1));

                            // babaguhin ung line next to this, case to case
                            Block tempBlock = new Block(x, y, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_teleporter).getTag().toString()));
                            tempBlock.setPx(px);
                            tempBlock.setPy(py);
                            tempBlock.setConnected(true);

                            // put in block object
                             blocks.add(tempBlock);

                            // find block and replace text, baguhin ung line na next, case to case
                            buttonsGrid.get(i).setText(popupView.findViewById(R.id.btn_createmap_popup_teleporter).getTag().toString());
                        }
                    }


                    popupWindow.dismiss();
                }
            });
        });


        // popup window views, teleporter, blackhole, immunity, disabled, next, baguhin ung next line, case to case
        popupView.findViewById(R.id.btn_createmap_popup_blackhole).setOnClickListener(view -> {
            // change background of kung ano mang pinress, next time
            Button tempButton = popupView.findViewById(R.id.btn_createmap_popup_blackhole);
            if (tempButton.isPressed()) {
                Toast.makeText(this, "Blackhole selected", Toast.LENGTH_SHORT).show();
                // next time na ung mag iiba background color, ill ask sir
//                tempButton.setBackgroundColor(getResources().getColor(R.color.gray, null));
            }


            popupView.findViewById(R.id.btn_createmap_popup_next).setOnClickListener(a -> {
                // get text from edit text
                EditText et = popupView.findViewById(R.id.et_createmap_popup_pcoordinate);
                pBlockCoordinates = et.getText().toString();

                // validation, dapat may partner lagi pag maglalagay ng block
                if (pBlockCoordinates.equals("")) {
                    Toast.makeText(this, "PUT A TAIL COORDINATE", Toast.LENGTH_LONG).show();

                } else {
                    // logic for getting the pressed button (blocks)
                    for(int i = 0; i < buttonsGrid.size(); i++) {
                        if(v.getId() == buttonsGrid.get(i).getId()) {
                            // get details of button (coordinates, type)
                            blockCoordinates = buttonsGrid.get(i).getTag().toString();
                            x = Integer.parseInt(blockCoordinates.substring(0, 1));
                            y = Integer.parseInt(blockCoordinates.substring(1));

                            // get coordinate of partner

                            px = Integer.parseInt(pBlockCoordinates.substring(0, 1));
                            py = Integer.parseInt(pBlockCoordinates.substring(1));

                            // babaguhin ung line next to this, case to case
                            Block tempBlock = new Block(x, y, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_blackhole).getTag().toString()));
                            tempBlock.setPx(px);
                            tempBlock.setPy(py);
                            tempBlock.setConnected(true);

                            // put in block object
                            blocks.add(tempBlock);

                            // find block and replace text, baguhin ung line na next, case to case
                            buttonsGrid.get(i).setText(popupView.findViewById(R.id.btn_createmap_popup_blackhole).getTag().toString());
                        }
                    }


                    popupWindow.dismiss();
                }
            });
        });


        // popup window views, teleporter, blackhole, immunity, disabled, next, baguhin ung next line, case to case
        popupView.findViewById(R.id.btn_createmap_popup_immunity).setOnClickListener(view -> {
            // change background of kung ano mang pinress, next time
            Button tempButton = popupView.findViewById(R.id.btn_createmap_popup_immunity);
            if (tempButton.isPressed()) {
                Toast.makeText(this, "Immunity selected", Toast.LENGTH_SHORT).show();
                // next time na ung mag iiba background color, ill ask sir
//                tempButton.setBackgroundColor(getResources().getColor(R.color.gray, null));
            }


            popupView.findViewById(R.id.btn_createmap_popup_next).setOnClickListener(a -> {
                // get text from edit text
                EditText et = popupView.findViewById(R.id.et_createmap_popup_pcoordinate);
                pBlockCoordinates = et.getText().toString();

                // validation, dapat may partner lagi pag maglalagay ng block
                if (pBlockCoordinates.equals("")) {
                    Toast.makeText(this, "PUT A TAIL COORDINATE", Toast.LENGTH_LONG).show();

                } else {
                    // logic for getting the pressed button (blocks)
                    for(int i = 0; i < buttonsGrid.size(); i++) {
                        if(v.getId() == buttonsGrid.get(i).getId()) {
                            // get details of button (coordinates, type)
                            blockCoordinates = buttonsGrid.get(i).getTag().toString();
                            x = Integer.parseInt(blockCoordinates.substring(0, 1));
                            y = Integer.parseInt(blockCoordinates.substring(1));

                            // get coordinate of partner

                            px = Integer.parseInt(pBlockCoordinates.substring(0, 1));
                            py = Integer.parseInt(pBlockCoordinates.substring(1));

                            // babaguhin ung line next to this, case to case
                            Block tempBlock = new Block(x, y, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_immunity).getTag().toString()));
                            tempBlock.setPx(px);
                            tempBlock.setPy(py);
                            tempBlock.setConnected(true);

                            // put in block object
                            blocks.add(tempBlock);

                            // find block and replace text, baguhin ung line na next, case to case
                            buttonsGrid.get(i).setText(popupView.findViewById(R.id.btn_createmap_popup_immunity).getTag().toString());
                        }
                    }


                    popupWindow.dismiss();
                }
            });
        });


        // popup window views, teleporter, blackhole, immunity, disabled, next, baguhin ung next line, case to case
        popupView.findViewById(R.id.btn_createmap_popup_disabled).setOnClickListener(view -> {
            // change background of kung ano mang pinress, next time
            Button tempButton = popupView.findViewById(R.id.btn_createmap_popup_disabled);
            if (tempButton.isPressed()) {
                Toast.makeText(this, "Disabled selected", Toast.LENGTH_SHORT).show();
                // next time na ung mag iiba background color, ill ask sir
//                tempButton.setBackgroundColor(getResources().getColor(R.color.gray, null));
            }


            popupView.findViewById(R.id.btn_createmap_popup_next).setOnClickListener(a -> {
                // get text from edit text
                EditText et = popupView.findViewById(R.id.et_createmap_popup_pcoordinate);
                pBlockCoordinates = et.getText().toString();

                // validation, dapat may partner lagi pag maglalagay ng block
                if (pBlockCoordinates.equals("")) {
                    Toast.makeText(this, "PUT A TAIL COORDINATE", Toast.LENGTH_LONG).show();

                } else {
                    // logic for getting the pressed button (blocks)
                    for(int i = 0; i < buttonsGrid.size(); i++) {
                        if(v.getId() == buttonsGrid.get(i).getId()) {
                            // get details of button (coordinates, type)
                            blockCoordinates = buttonsGrid.get(i).getTag().toString();
                            x = Integer.parseInt(blockCoordinates.substring(0, 1));
                            y = Integer.parseInt(blockCoordinates.substring(1));

                            // get coordinate of partner

                            px = Integer.parseInt(pBlockCoordinates.substring(0, 1));
                            py = Integer.parseInt(pBlockCoordinates.substring(1));

                            // babaguhin ung line next to this, case to case
                            Block tempBlock = new Block(x, y, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_disabled).getTag().toString()));
                            tempBlock.setPx(px);
                            tempBlock.setPy(py);
                            tempBlock.setConnected(true);

                            // put in block object
                            blocks.add(tempBlock);

                            // find block and replace text, baguhin ung line na next, case to case
                            buttonsGrid.get(i).setText(popupView.findViewById(R.id.btn_createmap_popup_disabled).getTag().toString());
                        }
                    }


                    popupWindow.dismiss();
                }
            });
        });
    }

    public void initButtonsGrid() {
        buttonsGrid.add(binding.btnCreatemap00);
        buttonsGrid.add(binding.btnCreatemap01);
        buttonsGrid.add(binding.btnCreatemap02);
        buttonsGrid.add(binding.btnCreatemap03);
        buttonsGrid.add(binding.btnCreatemap04);
        buttonsGrid.add(binding.btnCreatemap10);
        buttonsGrid.add(binding.btnCreatemap11);
        buttonsGrid.add(binding.btnCreatemap12);
        buttonsGrid.add(binding.btnCreatemap13);
        buttonsGrid.add(binding.btnCreatemap14);
        buttonsGrid.add(binding.btnCreatemap20);
        buttonsGrid.add(binding.btnCreatemap21);
        buttonsGrid.add(binding.btnCreatemap22);
        buttonsGrid.add(binding.btnCreatemap23);
        buttonsGrid.add(binding.btnCreatemap24);
        buttonsGrid.add(binding.btnCreatemap30);
        buttonsGrid.add(binding.btnCreatemap31);
        buttonsGrid.add(binding.btnCreatemap32);
        buttonsGrid.add(binding.btnCreatemap33);
        buttonsGrid.add(binding.btnCreatemap34);
        buttonsGrid.add(binding.btnCreatemap40);
        buttonsGrid.add(binding.btnCreatemap41);
        buttonsGrid.add(binding.btnCreatemap42);
        buttonsGrid.add(binding.btnCreatemap43);
        buttonsGrid.add(binding.btnCreatemap44);
        buttonsGrid.add(binding.btnCreatemap50);
        buttonsGrid.add(binding.btnCreatemap51);
        buttonsGrid.add(binding.btnCreatemap52);
        buttonsGrid.add(binding.btnCreatemap53);
        buttonsGrid.add(binding.btnCreatemap54);

        for(int i = 0; i < buttonsGrid.size(); i++) {
            buttonsGrid.get(i).setOnClickListener(this);
        }
    }
}