package com.eminyilmazz.househw.model;

public class Apartment extends House{
    public Apartment(double value, int squareSize, int livingRoomCount, int roomCount) {
        super(HousingType.fromValue("APARTMENT"), value, squareSize, livingRoomCount, roomCount);
    }
}
