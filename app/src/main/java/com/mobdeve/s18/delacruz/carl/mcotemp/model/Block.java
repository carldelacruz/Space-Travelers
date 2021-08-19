package com.mobdeve.s18.delacruz.carl.mcotemp.model;

public class Block {
    private int[] coordinates;
    private int type;
    private boolean isConnected;
    private boolean isOccupied;
    private Player isOccupiedByWho;
    private int[] partnerCoordinates;

    public Block(int[] coordinates, int type, boolean isConnected, boolean isOccupied) {
        this.coordinates = coordinates;
        this.type = type;
        this.isConnected = isConnected;
        this.isOccupied = isOccupied;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
        this.coordinates = coordinates;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Player getIsOccupiedByWho() {
        return isOccupiedByWho;
    }

    public void setIsOccupiedByWho(Player isOccupiedByWho) {
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
