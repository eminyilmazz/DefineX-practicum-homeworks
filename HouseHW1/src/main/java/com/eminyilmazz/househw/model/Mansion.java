package com.eminyilmazz.househw.model;

public class Mansion extends House{

    public Mansion(double value, int squareSize, int livingRoomCount, int roomCount) {
        super(HousingType.fromValue("MANSION"), value, squareSize, livingRoomCount, roomCount);
    }
}
