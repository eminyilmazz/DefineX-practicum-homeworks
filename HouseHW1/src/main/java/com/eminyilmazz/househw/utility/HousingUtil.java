package com.eminyilmazz.househw.utility;

import com.eminyilmazz.househw.model.Apartment;
import com.eminyilmazz.househw.model.House;
import com.eminyilmazz.househw.model.Mansion;
import com.eminyilmazz.househw.model.SummerHouse;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HousingUtil {
    private static final Logger logger = Logger.getLogger(HousingUtil.class);
    private static final Random rand = new Random();

    private HousingUtil() {
    }
    public static List<House> generateHouses() {
        List<House> housesList = new ArrayList<>();
        logger.trace("Generating houses.");
        List<House> apartmentList = generateApartments();
        List<House> mansionList = generateMansions();
        List<House> summerHouseList = generateSummerHouses();
        housesList.addAll(apartmentList);
        housesList.addAll(mansionList);
        housesList.addAll(summerHouseList);
        logger.trace("Generated all houses.");
        return housesList;
    }
    private static List<House> generateApartments() {
        House apartment1 = new Apartment((rand.nextDouble() * 100000.0) + 300000.0, 55, 1, 2);
        House apartment2 = new Apartment((rand.nextDouble() * 100000.0) + 400000.0, 105, 1, 2);
        House apartment3 = new Apartment((rand.nextDouble() * 100000.0) + 500000.0, 124, 1, 3);
        List<House> list = new ArrayList<>();
        list.add(apartment1);
        list.add(apartment2);
        list.add(apartment3);
        return list;
    }
    private static List<House> generateMansions() {
        House mansion1 = new Mansion((rand.nextDouble() * 300000.0) + 700000.0, 254, 2, 3);
        House mansion2 = new Mansion((rand.nextDouble() * 300000.0) + 800000.0, 270, 2, 5);
        House mansion3 = new Mansion((rand.nextDouble() * 300000.0) + 900000.0, 300, 3, 6);
        List<House> list = new ArrayList<>();
        list.add(mansion1);
        list.add(mansion2);
        list.add(mansion3);
        return list;
    }
    private static List<House> generateSummerHouses() {
        House summerHouse1 = new SummerHouse((rand.nextDouble() * 300000.0) + 500000.0, 150, 1, 2);
        House summerHouse2 = new SummerHouse((rand.nextDouble() * 300000.0) + 600000.0, 170, 1, 3);
        House summerHouse3 = new SummerHouse((rand.nextDouble() * 300000.0) + 700000.0, 200, 2, 5);
        List<House> list = new ArrayList<>();
        list.add(summerHouse1);
        list.add(summerHouse2);
        list.add(summerHouse3);
        return list;
    }
}
