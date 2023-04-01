package ParkingLot.Models;

public class ElectricParkingSlot {
    private  ParkingSlot parkingSlot;
    private Vehicle vehicle;

    public ElectricParkingSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
