package com.eminyilmazz.househw;

import com.eminyilmazz.househw.service.HousingExecutor;
import org.apache.log4j.BasicConfigurator;

public class HouseHW {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        HousingExecutor executor = new HousingExecutor();
        executor.execute();
    }
}
