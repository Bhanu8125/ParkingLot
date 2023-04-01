package ParkingLot.Strategy.SlotAssigment;

import ParkingLot.Models.Gate;
import ParkingLot.Models.ParkingSlot;
import ParkingLot.Models.VehicleSize;
import ParkingLot.Models.VehicleType;

public interface SlotAssignmentStrategy {
        ParkingSlot assignParkingSlot(VehicleType vehicleType, VehicleSize vehicleSize);

}
