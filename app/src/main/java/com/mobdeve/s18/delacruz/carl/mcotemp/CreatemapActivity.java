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
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Board;

import java.util.ArrayList;

/*NOTES
* 1. Clicking next in popup window without clicking on a type button doesn't show an error, walang validation*/
public class CreatemapActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityCreatemapBinding binding;
    private LayoutInflater layoutInflater;
    private ArrayList<Block> blocks = new ArrayList<>();
    private Board board;
    private ArrayList<Button> buttonsGrid = new ArrayList<>();
    private String blockCoordinates;
    private String pBlockCoordinates;
    private int blockNum;
    private int pBlockNum;


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
                if (Integer.parseInt(pBlockCoordinates) < 0 && Integer.parseInt(pBlockCoordinates) > 29) {
                    Toast.makeText(this, "BLOCK OUT OF RANGE", Toast.LENGTH_LONG).show();

                } else {
                    // logic for getting the pressed button (blocks)
                    for(int i = 0; i < buttonsGrid.size(); i++) {
                        if(v.getId() == buttonsGrid.get(i).getId()) {
                            // get details of button (coordinates, type)
                            blockCoordinates = buttonsGrid.get(i).getTag().toString();

                            // to be changed dahil nag iba ung coordinates
                            blockNum = Integer.parseInt(blockCoordinates);

                            // get coordinate of partner
                            pBlockNum = Integer.parseInt(pBlockCoordinates);

                            // babaguhin ung line next to this, case to case
                            Block tempBlock = new Block(blockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_teleporter).getTag().toString()));
                            tempBlock.setpBlockNum(pBlockNum);
                            tempBlock.setConnected(true);

                            // get details of partner block and put to arraylist of blocks
                            for(int j = 0; j < buttonsGrid.size(); j++) {
                                if(pBlockCoordinates.equals(buttonsGrid.get(j).getTag().toString())) {
                                    buttonsGrid.get(j).setText("T");
                                    buttonsGrid.get(j).setBackgroundColor(getColor(R.color.teal_200));

                                    // case to case
                                    Block tempBlock2 = new Block(pBlockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_teleporter).getTag().toString()));
                                    tempBlock2.setpBlockNum(blockNum);
                                    tempBlock2.setConnected(true);
                                    blocks.add(tempBlock2);
                                }
                            }

                            // put in block object
                             blocks.add(tempBlock);

                            // find block and replace text, baguhin ung line na next, case to case
                            buttonsGrid.get(i).setText("T");
                            buttonsGrid.get(i).setBackgroundColor(getColor(R.color.teal_200));
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
                if (Integer.parseInt(pBlockCoordinates) < 0 && Integer.parseInt(pBlockCoordinates) > 29) {
                    Toast.makeText(this, "BLOCK OUT OF RANGE", Toast.LENGTH_LONG).show();

                } else {
                    // logic for getting the pressed button (blocks)
                    for(int i = 0; i < buttonsGrid.size(); i++) {
                        if(v.getId() == buttonsGrid.get(i).getId()) {
                            // get details of button (coordinates, type)
                            blockCoordinates = buttonsGrid.get(i).getTag().toString();

                            // to be changed dahil nag iba ung coordinates
                            blockNum = Integer.parseInt(blockCoordinates);

                            // get coordinate of partner
                            pBlockNum = Integer.parseInt(pBlockCoordinates);

                            // babaguhin ung line next to this, case to case
                            Block tempBlock = new Block(blockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_blackhole).getTag().toString()));
                            tempBlock.setpBlockNum(pBlockNum);
                            tempBlock.setConnected(true);

                            // get details of partner block and put to arraylist of blocks
                            for(int j = 0; j < buttonsGrid.size(); j++) {
                                if(pBlockCoordinates.equals(buttonsGrid.get(j).getTag().toString())) {
                                    buttonsGrid.get(j).setText("B");
                                    buttonsGrid.get(j).setBackgroundColor(getColor(R.color.teal_200));
                                    // case to case
                                    Block tempBlock2 = new Block(pBlockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_blackhole).getTag().toString()));
                                    tempBlock2.setpBlockNum(blockNum);
                                    tempBlock2.setConnected(true);
                                    blocks.add(tempBlock2);
                                }
                            }

                            // put in block object
                            blocks.add(tempBlock);

                            // find block and replace text, baguhin ung line na next, case to case
                            buttonsGrid.get(i).setText("B");
                            buttonsGrid.get(i).setBackgroundColor(getColor(R.color.teal_200));
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
                if (Integer.parseInt(pBlockCoordinates) < 0 && Integer.parseInt(pBlockCoordinates) > 29) {
                    Toast.makeText(this, "BLOCK OUT OF RANGE", Toast.LENGTH_LONG).show();

                } else {
                    // logic for getting the pressed button (blocks)
                    for(int i = 0; i < buttonsGrid.size(); i++) {
                        if(v.getId() == buttonsGrid.get(i).getId()) {
                            // get details of button (coordinates, type)
                            blockCoordinates = buttonsGrid.get(i).getTag().toString();

                            // to be changed dahil nag iba ung coordinates
                            blockNum = Integer.parseInt(blockCoordinates);

                            // get coordinate of partner
                            pBlockNum = Integer.parseInt(pBlockCoordinates);

                            // babaguhin ung line next to this, case to case
                            Block tempBlock = new Block(blockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_immunity).getTag().toString()));
                            tempBlock.setpBlockNum(pBlockNum);
                            tempBlock.setConnected(true);

                            // get details of partner block and put to arraylist of blocks
                            for(int j = 0; j < buttonsGrid.size(); j++) {
                                if(pBlockCoordinates.equals(buttonsGrid.get(j).getTag().toString())) {
                                    buttonsGrid.get(j).setText("I");
                                    buttonsGrid.get(j).setBackgroundColor(getColor(R.color.teal_200));
                                    // case to case
                                    Block tempBlock2 = new Block(pBlockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_immunity).getTag().toString()));
                                    tempBlock2.setpBlockNum(blockNum);
                                    tempBlock2.setConnected(true);
                                    blocks.add(tempBlock2);
                                }
                            }

                            // put in block object
                            blocks.add(tempBlock);

                            // find block and replace text, baguhin ung line na next, case to case
                            buttonsGrid.get(i).setText("I");
                            buttonsGrid.get(i).setBackgroundColor(getColor(R.color.teal_200));
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
                if (Integer.parseInt(pBlockCoordinates) < 0 && Integer.parseInt(pBlockCoordinates) > 29) {
                    Toast.makeText(this, "BLOCK OUT OF RANGE", Toast.LENGTH_LONG).show();

                } else {
                    // logic for getting the pressed button (blocks)
                    for(int i = 0; i < buttonsGrid.size(); i++) {
                        if(v.getId() == buttonsGrid.get(i).getId()) {
                            // get details of button (coordinates, type)
                            blockCoordinates = buttonsGrid.get(i).getTag().toString();

                            // to be changed dahil nag iba ung coordinates
                            blockNum = Integer.parseInt(blockCoordinates);

                            // get coordinate of partner
                            pBlockNum = Integer.parseInt(pBlockCoordinates);

                            // babaguhin ung line next to this, case to case
                            Block tempBlock = new Block(blockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_disabled).getTag().toString()));
                            tempBlock.setpBlockNum(pBlockNum);
                            tempBlock.setConnected(true);

                            // get details of partner block and put to arraylist of blocks
                            for(int j = 0; j < buttonsGrid.size(); j++) {
                                if(pBlockCoordinates.equals(buttonsGrid.get(j).getTag().toString())) {
                                    buttonsGrid.get(j).setText("D");
                                    buttonsGrid.get(j).setBackgroundColor(getColor(R.color.teal_200));
                                    // case to case
                                    Block tempBlock2 = new Block(pBlockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_disabled).getTag().toString()));
                                    tempBlock2.setpBlockNum(blockNum);
                                    tempBlock2.setConnected(true);
                                    blocks.add(tempBlock2);
                                }
                            }

                            // put in block object
                            blocks.add(tempBlock);

                            // find block and replace text, baguhin ung line na next, case to case
                            buttonsGrid.get(i).setText("D");
                            buttonsGrid.get(i).setBackgroundColor(getColor(R.color.teal_200));
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