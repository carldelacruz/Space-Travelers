package com.mobdeve.s18.group16.delacruz_dizon.space_travelers.model;

import java.util.ArrayList;

public class Board {
    private int numPlayers;
    private ArrayList<Player> players;
    private ArrayList<Block> blocks;

    public Board(int numPlayers, ArrayList<Player> players, ArrayList<Block> blocks) {
        this.numPlayers = numPlayers;
        this.players = players;
        this.blocks = blocks;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }
}
