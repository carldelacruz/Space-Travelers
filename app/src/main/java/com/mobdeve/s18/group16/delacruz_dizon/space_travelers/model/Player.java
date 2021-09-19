package com.mobdeve.s18.group16.delacruz_dizon.space_travelers.model;

public class Player {
    private int playerNum;
    private int[] pos;
    private int status;
    private boolean isAI;

    public Player(int playerNum, int[] pos, int status, boolean isAI) {
        this.playerNum = playerNum;
        this.pos = pos;
        this.status = status;
        this.isAI = isAI;
    }

    public boolean isAI() {
        return isAI;
    }

    public void setAI(boolean AI) {
        isAI = AI;
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
