package ParkingLot.Factory;

import ParkingLot.Models.VehicleSize;
import ParkingLot.Strategy.FeesCalculation.*;
import ParkingLot.Strategy.FeesCalculation.BikeFeesCalculationStrategy;

public class FeesCalculationFactory {

    public static  FeesCalculationStrategy getFeesCalculationStrategyInstance(VehicleSize vehicleSize){

        return switch(vehicleSize){
            case Bicycle -> new BicycleFeesCalculationStrategy();
            case Two_Wheeler ->  new BikeFeesCalculationStrategy();
            case Four_Wheeler -> new CarFeesCalculationStrategy();
            case Heavy ->  new HeavyFeesCalculationStrategy();
        };
    }
}
