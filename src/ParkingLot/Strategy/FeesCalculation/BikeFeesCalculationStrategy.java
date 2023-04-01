package ParkingLot.Strategy.FeesCalculation;

import ParkingLot.Models.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BikeFeesCalculationStrategy implements FeesCalculationStrategy{

    private double chargePerHour;
    @Override
    public double calculateFees(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime, double surge) {
        chargePerHour = getVehicleTyeChargePerHour(vehicleType);
        long hours = exitTime.until(entryTime, ChronoUnit.HOURS);
        double totalFees = chargePerHour * hours;
        totalFees*=surge;
        return totalFees;
    }

    private double getVehicleTyeChargePerHour(VehicleType vehicleType){
        return switch(vehicleType){
            case Fuel -> 40;
            case Electric -> 50;
        };
    }
}
