package com.eminyilmazz.househw.model;

public enum HousingType {

    APARTMENT("APARTMENT"), MANSION("MANSION"), SUMMER_HOUSE("SUMMER HOUSE");

    private final String type;

    private HousingType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public static HousingType fromValue(String type) {
        for (HousingType housingType : values()) {
            if (housingType.getType().equalsIgnoreCase(type)) {
                return housingType;
            }
        }
        throw new IllegalArgumentException("Invalid Housing Type: " + type);
    }
}
