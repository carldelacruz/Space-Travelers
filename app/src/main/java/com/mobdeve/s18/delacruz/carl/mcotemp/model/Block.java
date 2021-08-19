package com.mobdeve.s18.delacruz.carl.mcotemp.model;
/*
* Type: 0 - normal block
*       1 - teleport
*       2 - blackhole
*       3 - immunity
*       4 - disabled*/
public class Block {
    private int x;
    private int y;
    private int type;
    private boolean isConnected;
    private boolean isOccupied;
    private int isOccupiedByWho;
    private int[] partnerCoordinates;

    public Block(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public int[] getPartnerCoordinates() {
        return partnerCoordinates;
    }

    public void setPartnerCoordinates(int[] partnerCoordinates) {
        this.partnerCoordinates = partnerCoordinates;
    }
}
