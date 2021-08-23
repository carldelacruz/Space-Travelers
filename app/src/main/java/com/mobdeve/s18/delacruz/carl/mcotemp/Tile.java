package com.mobdeve.s18.delacruz.carl.mcotemp;

public class Tile {
    private String type;
    private int coordinates, imageId;


    public Tile(String type, int coordinates){
        this.type = type;
        this.coordinates = coordinates;
        this.imageId = R.drawable.tile;
    }
    public String getType(){ return type; }
    public int getCoordinates(){ return coordinates; }
    public int getImageId(){ return  imageId;}
}
