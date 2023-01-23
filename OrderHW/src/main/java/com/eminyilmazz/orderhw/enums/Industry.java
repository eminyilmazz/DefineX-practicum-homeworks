package com.eminyilmazz.orderhw.enums;

import java.util.Arrays;

public enum Industry {
    TECH("TECH"), FINANCE("FINANCE"), FASHION("FASHION"), COSMETIC("COSMETIC"), OTHER("OTHER");

    private String value;

    Industry(String value) {
        this.value = value;
    }

    public static Industry fromValue(String type) {
        return Arrays.stream(Industry.values())
                .filter(industry -> industry.value.equalsIgnoreCase(type))
                .findFirst()
                .orElse(Industry.OTHER);
    }

    public String getValue() {
        return this.value;
    }

}
