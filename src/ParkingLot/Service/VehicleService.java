package ParkingLot.Service;

import ParkingLot.Models.Vehicle;
import ParkingLot.Models.VehicleSize;
import ParkingLot.Models.VehicleType;

public interface VehicleService {
    Vehicle saveVehicle(String vehicleNumber, VehicleType vehicleType, VehicleSize vehicleSize);
    Vehicle getVehicle(String vehicleNumber);
}
