package ParkingLot.Repository;


import ParkingLot.Models.ParkingFloor;
import ParkingLot.Models.ParkingSlot;

import java.util.List;

public interface ParkingLotRepository {
    List<List<ParkingSlot>> getParkingSlots();
    //void loadParkingLot();

    void setParkingFloors(List<ParkingFloor>  parkingFloors);

    void setParkingSlots(List<List<ParkingSlot>> parkingSlots);
    List<ParkingFloor> getParkingFloors();

}
