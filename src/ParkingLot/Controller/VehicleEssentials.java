package ParkingLot.Controller;

import ParkingLot.Models.VehicleSize;
import ParkingLot.Models.VehicleType;

public class VehicleEssentials {
    public  static VehicleType getVehicleType(String vehicleType){
        return switch(vehicleType.toLowerCase()){
            case "fuel" -> VehicleType.Fuel;
            case "electric" -> VehicleType.Electric;
            default->null;
        };
    }

    public static VehicleSize getVehicleSize(String vehicleSize){
        return switch(vehicleSize.toLowerCase()){
            case "bicycle" -> VehicleSize.Bicycle;
            case "two wheeler" -> VehicleSize.Two_Wheeler;
            case "four wheeler" -> VehicleSize.Four_Wheeler;
            case "heavy" -> VehicleSize.Heavy;
            default -> null;
        };
    }


}
