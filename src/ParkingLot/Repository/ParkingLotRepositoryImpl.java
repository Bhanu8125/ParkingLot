package ParkingLot.Repository;

import ParkingLot.Factory.ParkingLotFactory;
import ParkingLot.Models.ParkingFloor;
import ParkingLot.Models.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepositoryImpl implements ParkingLotRepository{
    private List<List<ParkingSlot>> parkingSlots;
    private List<ParkingFloor> parkingFloors;

    private static ParkingLotRepository parkingLotRepository;

//    @Override
//    public  void loadParkingLot(){
//        ParkingLotFactory parkingLotFactory = ParkingLotFactory.getInstance();
//        parkingSlots = parkingLotFactory.getParkingSlots();
//        parkingFloors = parkingLotFactory.getParkingFloors();
//    }
    @Override
    public List<List<ParkingSlot>> getParkingSlots() {
        return parkingSlots;
    }


    @Override
    public void setParkingSlots(List<List<ParkingSlot>> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    @Override
    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    @Override
    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLotRepository getInstance(){
        if(parkingLotRepository==null){
            synchronized (ParkingLotRepository.class){
                if(parkingLotRepository ==  null){
                    parkingLotRepository = new ParkingLotRepositoryImpl();
                }
            }
        }
        return parkingLotRepository;
    }
}
