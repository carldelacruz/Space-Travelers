package com.mobdeve.s18.delacruz.carl.mcotemp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mobdeve.s18.delacruz.carl.mcotemp.DAO.DAOSQLImpl;
import com.mobdeve.s18.delacruz.carl.mcotemp.databinding.ActivityCreatemapBinding;
import com.mobdeve.s18.delacruz.carl.mcotemp.model.Block;

import java.util.ArrayList;

/*NOTES
 * 1. Clicking next in popup window without clicking on a blockType button doesn't show an error, walang validation
 * 2. */
public class CreatemapActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityCreatemapBinding binding;
    private LayoutInflater layoutInflater;
    private ArrayList<Block> blocks = new ArrayList<>();
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

        binding.btnCreatemapSave.setOnClickListener(v -> {
            if (!binding.etCreatemapNameofmap.getText().toString().equals("")) {
                String mapName = binding.etCreatemapNameofmap.getText().toString();

                DAOSQLImpl database = new DAOSQLImpl(this);

                // fill it up with map name
                for(int j = 0; j < blocks.size(); j++) {
                    blocks.get(j).setMapName(mapName);
                }

                boolean result = database.addData(blocks);

                if (!result) {
                    Toast.makeText(this, "DATA NOT ADDED TO DATABASE", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "DATA ADDED TO DATABASE SUCCESSFULLY", Toast.LENGTH_LONG).show();
                }

                Intent gotoHome = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(gotoHome);

                ArrayList<Block> blocksContainer = database.getBlocks();



                for(int i = 0; i < blocksContainer.size(); i++) {
                    String getter = "\n Block num: " + blocksContainer.get(i).getBlockNum()
                            + "\n Block type: " + blocksContainer.get(i).getBlockType()
                            + "\n IsConnected: " + blocksContainer.get(i).getIsConnected()
                            + "\n pBlockNum: " + blocksContainer.get(i).getpBlockNum()
                            + "\n isHead: " + blocksContainer.get(i).getIsHead()
                            + "\n mapNum: " + blocksContainer.get(i).getMapName();

                    Log.i("Details: ", getter, null);

//                    Toast.makeText(this, "\n Block num: " + blocks.get(i).getBlockNum()
//                                    + "\n Block type: " + blocks.get(i).getBlockType()
//                                    + "\n IsConnected: " + blocks.get(i).getIsConnected()
//                                    + "\n pBlockNum: " + blocks.get(i).getpBlockNum()
//                                    + "\n isHead: " + blocks.get(i).getIsHead()
//                            , Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this, "YOU DIDN'T PUT A MAP NAME", Toast.LENGTH_LONG).show();
            }
        });
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

        // validation, pag wala pa napress na blockType (teleport, blackhole, immunity, disabled) button
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


                // validation, pag may laman ung pblockcoordinate
                if (!pBlockCoordinates.equals("")) {
                    // validation, dapat may partner lagi pag maglalagay ng block
                    if (Integer.parseInt(pBlockCoordinates) < 0 || Integer.parseInt(pBlockCoordinates) > 29) {
                        Toast.makeText(this, "BLOCK OUT OF RANGE", Toast.LENGTH_LONG).show();

                    } else {
                        // logic for getting the pressed button (blocks)
                        for(int i = 0; i < buttonsGrid.size(); i++) {
                            if(v.getId() == buttonsGrid.get(i).getId()) {
                                // get details of button (coordinates, blockType)
                                blockCoordinates = buttonsGrid.get(i).getTag().toString();

                                // to be changed dahil nag iba ung coordinates
                                blockNum = Integer.parseInt(blockCoordinates);

                                // get coordinate of partner
                                pBlockNum = Integer.parseInt(pBlockCoordinates);

                                // babaguhin ung line next to this, case to case
                                Block tempBlock = new Block(blockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_teleporter).getTag().toString()));
                                tempBlock.setpBlockNum(pBlockNum);
                                tempBlock.setConnected(1);
                                tempBlock.setHead(1);

                                // get details of partner block and put to arraylist of blocks
                                for(int j = 0; j < buttonsGrid.size(); j++) {
                                    if(pBlockCoordinates.equals(buttonsGrid.get(j).getTag().toString())) {
                                        buttonsGrid.get(j).setText("T");
                                        buttonsGrid.get(j).setBackgroundColor(getColor(R.color.teal_200));

                                        // case to case
                                        Block tempBlock2 = new Block(pBlockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_teleporter).getTag().toString()));
                                        tempBlock2.setpBlockNum(blockNum);
                                        tempBlock2.setConnected(1);
                                        tempBlock2.setHead(0);
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
                } else {
                    Toast.makeText(this, "YOU DIDN'T PUT A COORDINATE", Toast.LENGTH_LONG).show();
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


                // validation, pag may laman ung pblockcoordinate
                if (!pBlockCoordinates.equals("")) {
                    // validation, dapat may partner lagi pag maglalagay ng block
                    if (Integer.parseInt(pBlockCoordinates) < 0 || Integer.parseInt(pBlockCoordinates) > 29) {
                        Toast.makeText(this, "BLOCK OUT OF RANGE", Toast.LENGTH_LONG).show();

                    } else {
                        // logic for getting the pressed button (blocks)
                        for (int i = 0; i < buttonsGrid.size(); i++) {
                            if (v.getId() == buttonsGrid.get(i).getId()) {
                                // get details of button (coordinates, blockType)
                                blockCoordinates = buttonsGrid.get(i).getTag().toString();

                                // to be changed dahil nag iba ung coordinates
                                blockNum = Integer.parseInt(blockCoordinates);

                                // get coordinate of partner
                                pBlockNum = Integer.parseInt(pBlockCoordinates);

                                // babaguhin ung line next to this, case to case
                                Block tempBlock = new Block(blockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_blackhole).getTag().toString()));
                                tempBlock.setpBlockNum(pBlockNum);
                                tempBlock.setConnected(1);
                                tempBlock.setHead(1);

                                // get details of partner block and put to arraylist of blocks
                                for (int j = 0; j < buttonsGrid.size(); j++) {
                                    if (pBlockCoordinates.equals(buttonsGrid.get(j).getTag().toString())) {
                                        buttonsGrid.get(j).setText("B");
                                        buttonsGrid.get(j).setBackgroundColor(getColor(R.color.teal_200));

                                        // case to case
                                        Block tempBlock2 = new Block(pBlockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_blackhole).getTag().toString()));
                                        tempBlock2.setpBlockNum(blockNum);
                                        tempBlock2.setConnected(1);
                                        tempBlock2.setHead(0);
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
                } else {
                    Toast.makeText(this, "YOU DIDN'T PUT A COORDINATE", Toast.LENGTH_LONG).show();
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


                // validation, pag may laman ung pblockcoordinate
                if (!pBlockCoordinates.equals("")) {
                    // validation, dapat may partner lagi pag maglalagay ng block
                    if (Integer.parseInt(pBlockCoordinates) < 0 || Integer.parseInt(pBlockCoordinates) > 29) {
                        Toast.makeText(this, "BLOCK OUT OF RANGE", Toast.LENGTH_LONG).show();

                    } else {
                        // logic for getting the pressed button (blocks)
                        for (int i = 0; i < buttonsGrid.size(); i++) {
                            if (v.getId() == buttonsGrid.get(i).getId()) {
                                // get details of button (coordinates, blockType)
                                blockCoordinates = buttonsGrid.get(i).getTag().toString();

                                // to be changed dahil nag iba ung coordinates
                                blockNum = Integer.parseInt(blockCoordinates);

                                // get coordinate of partner
                                pBlockNum = Integer.parseInt(pBlockCoordinates);

                                // babaguhin ung line next to this, case to case
                                Block tempBlock = new Block(blockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_immunity).getTag().toString()));
                                tempBlock.setpBlockNum(pBlockNum);
                                tempBlock.setConnected(1);
                                tempBlock.setHead(1);

                                // get details of partner block and put to arraylist of blocks
                                for (int j = 0; j < buttonsGrid.size(); j++) {
                                    if (pBlockCoordinates.equals(buttonsGrid.get(j).getTag().toString())) {
                                        buttonsGrid.get(j).setText("I");
                                        buttonsGrid.get(j).setBackgroundColor(getColor(R.color.teal_200));

                                        // case to case
                                        Block tempBlock2 = new Block(pBlockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_immunity).getTag().toString()));
                                        tempBlock2.setpBlockNum(blockNum);
                                        tempBlock2.setConnected(1);
                                        tempBlock2.setHead(0);
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
                } else {
                    Toast.makeText(this, "YOU DIDN'T PUT A COORDINATE", Toast.LENGTH_LONG).show();
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


                // validation, pag may laman ung pblockcoordinate
                if (!pBlockCoordinates.equals("")) {
                    // validation, dapat may partner lagi pag maglalagay ng block
                    if (Integer.parseInt(pBlockCoordinates) < 0 || Integer.parseInt(pBlockCoordinates) > 29) {
                        Toast.makeText(this, "BLOCK OUT OF RANGE", Toast.LENGTH_LONG).show();

                    } else {
                        // logic for getting the pressed button (blocks)
                        for(int i = 0; i < buttonsGrid.size(); i++) {
                            if(v.getId() == buttonsGrid.get(i).getId()) {
                                // get details of button (coordinates, blockType)
                                blockCoordinates = buttonsGrid.get(i).getTag().toString();

                                // to be changed dahil nag iba ung coordinates
                                blockNum = Integer.parseInt(blockCoordinates);

                                // get coordinate of partner
                                pBlockNum = Integer.parseInt(pBlockCoordinates);

                                // babaguhin ung line next to this, case to case
                                Block tempBlock = new Block(blockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_disabled).getTag().toString()));
                                tempBlock.setpBlockNum(pBlockNum);
                                tempBlock.setConnected(1);
                                tempBlock.setHead(1);


                                // get details of partner block and put to arraylist of blocks
                                for(int j = 0; j < buttonsGrid.size(); j++) {
                                    if(pBlockCoordinates.equals(buttonsGrid.get(j).getTag().toString())) {
                                        buttonsGrid.get(j).setText("D");
                                        buttonsGrid.get(j).setBackgroundColor(getColor(R.color.teal_200));

                                        // case to case
                                        Block tempBlock2 = new Block(pBlockNum, Integer.parseInt(popupView.findViewById(R.id.btn_createmap_popup_disabled).getTag().toString()));
                                        tempBlock2.setpBlockNum(blockNum);
                                        tempBlock2.setConnected(1);
                                        tempBlock2.setHead(0);
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
                } else {
                    Toast.makeText(this, "YOU DIDN'T PUT A COORDINATE", Toast.LENGTH_LONG).show();
                }
            });
        });
    }

    public void initButtonsGrid() {
        buttonsGrid.add(binding.btnCreatemap0);
        buttonsGrid.add(binding.btnCreatemap1);
        buttonsGrid.add(binding.btnCreatemap2);
        buttonsGrid.add(binding.btnCreatemap3);
        buttonsGrid.add(binding.btnCreatemap4);
        buttonsGrid.add(binding.btnCreatemap5);
        buttonsGrid.add(binding.btnCreatemap6);
        buttonsGrid.add(binding.btnCreatemap7);
        buttonsGrid.add(binding.btnCreatemap8);
        buttonsGrid.add(binding.btnCreatemap9);
        buttonsGrid.add(binding.btnCreatemap10);
        buttonsGrid.add(binding.btnCreatemap11);
        buttonsGrid.add(binding.btnCreatemap12);
        buttonsGrid.add(binding.btnCreatemap13);
        buttonsGrid.add(binding.btnCreatemap14);
        buttonsGrid.add(binding.btnCreatemap15);
        buttonsGrid.add(binding.btnCreatemap16);
        buttonsGrid.add(binding.btnCreatemap17);
        buttonsGrid.add(binding.btnCreatemap18);
        buttonsGrid.add(binding.btnCreatemap19);
        buttonsGrid.add(binding.btnCreatemap20);
        buttonsGrid.add(binding.btnCreatemap21);
        buttonsGrid.add(binding.btnCreatemap22);
        buttonsGrid.add(binding.btnCreatemap23);
        buttonsGrid.add(binding.btnCreatemap24);
        buttonsGrid.add(binding.btnCreatemap25);
        buttonsGrid.add(binding.btnCreatemap26);
        buttonsGrid.add(binding.btnCreatemap27);
        buttonsGrid.add(binding.btnCreatemap28);
        buttonsGrid.add(binding.btnCreatemap29);

        for(int i = 0; i < buttonsGrid.size(); i++) {
            buttonsGrid.get(i).setOnClickListener(this);
        }
    }
}