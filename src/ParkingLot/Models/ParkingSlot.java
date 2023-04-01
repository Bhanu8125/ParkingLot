package ParkingLot.Models;

import java.util.List;

public class ParkingSlot extends  BaseClass{
    private ParkingFloor parkingFloor;
    private List<VehicleType> supportedVehicleType;
    private VehicleSize supportedVehicleSize;
    private ParkingState parkingState;

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public List<VehicleType> getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public void setSupportedVehicleType(List<VehicleType> supportedVehicleType) {
        this.supportedVehicleType = supportedVehicleType;
    }

    public VehicleSize getSupportedVehicleSize() {
        return supportedVehicleSize;
    }

    public void setSupportedVehicleSize(VehicleSize supportedVehicleSize) {
        this.supportedVehicleSize = supportedVehicleSize;
    }

    public ParkingState getParkingState() {
        return parkingState;
    }

    public void setParkingState(ParkingState parkingState) {
        this.parkingState = parkingState;
    }

    public void setParkingSlotId(long parkingSlotId){
        this.setId(parkingSlotId);
    }
    public long getParkingSlotId(){
        return this.getId();
    }
}
