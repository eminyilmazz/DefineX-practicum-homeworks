package com.eminyilmazz.househw.model;

public class SummerHouse extends House{
    public SummerHouse(double value, int squareSize, int livingRoomCount, int roomCount) {
        super(HousingType.fromValue("SUMMER HOUSE"), value, squareSize, livingRoomCount, roomCount);
    }
}
