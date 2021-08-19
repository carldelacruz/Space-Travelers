package com.mobdeve.s18.delacruz.carl.mcotemp.model;

public class Player {
    private int playerNum;
    private int[] pos;
    private int status;

    public Player(int playerNum, int[] pos, int status) {
        this.playerNum = playerNum;
        this.pos = pos;
        this.status = status;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
