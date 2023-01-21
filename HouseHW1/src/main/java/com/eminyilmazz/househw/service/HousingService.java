package com.eminyilmazz.househw.service;

import com.eminyilmazz.househw.model.House;
import com.eminyilmazz.househw.model.HousingType;
import com.eminyilmazz.househw.utility.HousingUtil;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class HousingService {
    private static final Logger logger = Logger.getLogger(HousingService.class);
    private static final List<House> houseList = HousingUtil.generateHouses();

    public double getTotalValue() {
        logger.trace("executing: getTotalValue");
        return houseList.stream()
                .mapToDouble(House::getValue)
                .sum();
    }

    public double getTotalValueByType(HousingType type) {
        logger.trace("executing: getTotalValueByType");
        return houseList.stream()
                .filter(house -> house.getType() == type)
                .mapToDouble(House::getValue)
                .sum();
    }

    public int getTotalSquareSizeByType(HousingType type) {
        logger.trace("executing: getTotalSquareSizeByType");
        return houseList.stream()
                .filter(house -> house.getType() == type)
                .mapToInt(House::getSquareSize)
                .sum();
    }

    public double getAverageSquareSize() {
        logger.trace("executing: getAverageSquareSize");
        int totalSquareSize = 0;
        int count = 0;
        for (House house : houseList) {
            totalSquareSize += house.getSquareSize();
            count++;
        }
        if (count == 0) return 0.0;
        else return (double) totalSquareSize / count;
    }

    public List<House> filterByLivingRoomAndRoomCount(int livingRoomCount, int roomCount) {
        logger.trace("executing: filterByLivingRoomAndRoomCount");
        logger.trace("filters;\nliving room count: " + livingRoomCount + "\nroom count: " + roomCount);
        return houseList.stream()
                .filter(house -> house.getLivingRoomCount() == livingRoomCount && house.getRoomCount() == roomCount)
                .collect(Collectors.toList());
    }
}
