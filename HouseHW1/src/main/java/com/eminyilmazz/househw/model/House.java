package com.eminyilmazz.househw.model;

import org.apache.log4j.Logger;

public class House {
    private HousingType type;
    private double value;
    private int squareSize;
    private int livingRoomCount;
    private int roomCount;
    private static final Logger logger = Logger.getLogger(House.class);

    public House(HousingType type, double value, int squareSize, int livingRoomCount, int roomCount) {
        logger.debug("Creating a house with type: " + type.getType());
        this.type = type;
        this.value = value;
        this.squareSize = squareSize;
        this.livingRoomCount = livingRoomCount;
        this.roomCount = roomCount;
    }
    public HousingType getType() {
        return type;
    }
    public double getValue() {
        return value;
    }
    public int getSquareSize() {
        return squareSize;
    }
    public int getLivingRoomCount() {
        return livingRoomCount;
    }
    public int getRoomCount() {
        return roomCount;
    }
}
