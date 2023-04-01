package ParkingLot.Repository;

import ParkingLot.Models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepositoryImpl implements VehicleRepository{

    private Map<String, Vehicle> vehicles;
    private static VehicleRepository vehicleRepository;
    private VehicleRepositoryImpl() {
        this.vehicles = new HashMap<String, Vehicle>();
    }
    @Override
    public void saveVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleNumber(), vehicle);
    }
    @Override
    public Vehicle getVehicle(String vehicleNumber) {
        return vehicles.getOrDefault(vehicleNumber,null);
    }

    public static VehicleRepository getInstance(){
        if(vehicleRepository==null){
            synchronized (VehicleRepository.class){
                if(vehicleRepository ==  null){
                    vehicleRepository = new VehicleRepositoryImpl();
                }
            }
        }
        return vehicleRepository;
    }
}
