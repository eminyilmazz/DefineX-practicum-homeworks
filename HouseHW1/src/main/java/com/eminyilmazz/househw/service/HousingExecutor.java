package com.eminyilmazz.househw.service;

import com.eminyilmazz.househw.model.HousingType;
import org.apache.log4j.Logger;

public class HousingExecutor {
    private static final HousingService housingService = new HousingService();
    private static final Logger logger = Logger.getLogger(HousingExecutor.class);
    public void execute(){
        logger.info("Started execution.");
        logger.debug(String.format("The total value of the houses: %,.2f", housingService.getTotalValue()));
        logger.debug(String.format("The total value of the apartments: %,.2f", housingService.getTotalValueByType(HousingType.fromValue("APARTMENT"))));
        logger.debug(String.format("The total value of the mansions: %,.2f", housingService.getTotalValueByType(HousingType.fromValue("MANSION"))));
        logger.debug(String.format("The total value of the summer houses: %,.2f", housingService.getTotalValueByType(HousingType.fromValue("SUMMER HOUSE"))));
        logger.debug(String.format("The total square size of the apartments: %d", housingService.getTotalSquareSizeByType(HousingType.fromValue("APARTMENT"))));
        logger.debug(String.format("The total square size of the mansions: %d", housingService.getTotalSquareSizeByType(HousingType.fromValue("MANSION"))));
        logger.debug(String.format("The total square size of the summer houses: %d", housingService.getTotalSquareSizeByType(HousingType.fromValue("SUMMER HOUSE"))));
        logger.debug(String.format("The average square size of the houses: %.2f", housingService.getAverageSquareSize()));
        logger.debug(String.format("The total count of the house with 1 living room and 2 rooms %d ", housingService.filterByLivingRoomAndRoomCount(1, 2).size()));
        logger.debug(String.format("The total count of the house with 1 living room and 3 rooms %d ", housingService.filterByLivingRoomAndRoomCount(1, 3).size()));
        logger.debug(String.format("The total count of the house with 2 living rooms and 3 rooms %d ", housingService.filterByLivingRoomAndRoomCount(2, 3).size()));
        logger.debug(String.format("The total count of the house with 2 living room and 5 rooms %d ", housingService.filterByLivingRoomAndRoomCount(2, 5).size()));
        logger.debug(String.format("The total count of the house with 3 living room and 6 rooms %d ", housingService.filterByLivingRoomAndRoomCount(3, 6).size()));

    }
}
