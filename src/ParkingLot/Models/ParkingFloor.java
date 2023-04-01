package ParkingLot.Models;

import java.util.List;

public class ParkingFloor extends BaseClass{

    private List<ParkingSlot> parkingSlotList;
    private ParkingState parkingState;

    public void setParkingFloorId(long parkingFloorId){
        this.setId(parkingFloorId);
    }
    public long getParkingFloorId(){
        return this.getId();
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public ParkingState getParkingState() {
        return parkingState;
    }

    public void setParkingState(ParkingState parkingState) {
        this.parkingState = parkingState;
    }

}
