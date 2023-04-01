package ParkingLot.Strategy.FeesCalculation;

import ParkingLot.Models.VehicleSize;
import ParkingLot.Models.VehicleType;
import ParkingLot.Repository.VehicleRepository;

import java.time.LocalDateTime;

public interface FeesCalculationStrategy {
    double calculateFees(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime, double surge);
}
