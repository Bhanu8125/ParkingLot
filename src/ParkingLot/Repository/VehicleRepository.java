package ParkingLot.Repository;

import ParkingLot.Models.Vehicle;

public interface VehicleRepository {
     void saveVehicle(Vehicle vehicle);
    Vehicle getVehicle(String vehicleNumber);
}
