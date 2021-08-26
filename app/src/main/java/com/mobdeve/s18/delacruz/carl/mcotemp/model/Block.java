package com.mobdeve.s18.delacruz.carl.mcotemp.model;
/*
* Type: 0 - normal block
*       1 - teleport
*       2 - blackhole
*       3 - immunity
*       4 - disabled*/
public class Block {
    private int blockNum;
    private int type = 0;
    private boolean isConnected;
    private boolean isOccupied;
    private int isOccupiedByWho;
    private int pBlockNum;
    private boolean isHead;

    public Block(int pBlockNum, int type) {
        this.pBlockNum = pBlockNum;
        this.type = type;
    }

    public int getBlockNum() {
        return blockNum;
    }

    public void setBlockNum(int blockNum) {
        this.blockNum = blockNum;
    }

    public int getpBlockNum() {
        return pBlockNum;
    }

    public void setpBlockNum(int pBlockNum) {
        this.pBlockNum = pBlockNum;
    }

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsOccupiedByWho() {
        return isOccupiedByWho;
    }

    public void setIsOccupiedByWho(int isOccupiedByWho) {
        this.isOccupiedByWho = isOccupiedByWho;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
