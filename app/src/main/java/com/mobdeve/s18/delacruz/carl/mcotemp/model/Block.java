package com.mobdeve.s18.delacruz.carl.mcotemp.model;
/*
 * Type: 0 - normal block
 *       1 - teleport
 *       2 - blackhole
 *       3 - immunity
 *       4 - disabled
 *
 * Occupied by who: 1 - player 1
 *                  2 - player 2
 *                  3 - player 3
 *                  4 - player 4*/
public class Block {
    private int blockNum;
    private int blockType;
    private int isConnected; // serves as boolean 1 and 0
    private int isOccupied; // serves as boolean 1 and 0
    private int isOccupiedByWho;
    private int pBlockNum;
    private int isHead; // serves as boolean 1 and 0
    private String mapName;

    public Block(int blockNum, int blockType) {
        this.blockNum = blockNum;
        this.blockType = blockType;
    }

    public Block() {
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
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

    public int getIsHead() {
        return isHead;
    }

    public void setHead(int head) {
        isHead = head;
    }

    public int getBlockType() {
        return blockType;
    }

    public void setBlockType(int blockType) {
        this.blockType = blockType;
    }

    public int getIsOccupiedByWho() {
        return isOccupiedByWho;
    }

    public void setIsOccupiedByWho(int isOccupiedByWho) {
        this.isOccupiedByWho = isOccupiedByWho;
    }

    public int getIsConnected() {
        return isConnected;
    }

    public void setConnected(int connected) {
        isConnected = connected;
    }

    public int isOccupied() {
        return isOccupied;
    }

    public void setOccupied(int occupied) {
        isOccupied = occupied;
    }
}
