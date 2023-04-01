package ParkingLot.Strategy.SlotAssigment;

import ParkingLot.Models.*;
import ParkingLot.Repository.ParkingLotRepository;
import ParkingLot.Repository.ParkingLotRepositoryImpl;

import java.util.List;

public class findNearestParkingSlot implements SlotAssignmentStrategy {

    private static SlotAssignmentStrategy slotAssignmentStrategy;

    private  ParkingLotRepository parkingLotRepository;
    private List<ParkingFloor> parkingFloors;
    private List<List<ParkingSlot>> parkingSlots;

    public findNearestParkingSlot() {
        parkingLotRepository = ParkingLotRepositoryImpl.getInstance();
        //parkingLotRepository.loadParkingLot();
        parkingFloors = parkingLotRepository.getParkingFloors();
        parkingSlots = parkingLotRepository.getParkingSlots();
    }

    @Override
    public ParkingSlot assignParkingSlot(VehicleType vehicleType, VehicleSize vehicleSize) {
        parkingSlots = parkingLotRepository.getParkingSlots();
        for(int i=0;i<parkingSlots.size();i++){
            for(ParkingSlot parkingSlot : parkingSlots.get(i)){
                if(parkingSlot.getSupportedVehicleType().equals(vehicleType) && parkingSlot.getSupportedVehicleSize().equals(vehicleSize)){
                    return parkingSlot;
                }
            }
        }

        for(int i=0;i<parkingSlots.size();i++){
            for(ParkingSlot parkingSlot : parkingSlots.get(i)){
                if(parkingSlot.getSupportedVehicleSize().equals(vehicleSize) && !parkingSlot.getSupportedVehicleType().equals(vehicleType)){
                    return parkingSlot;
                }
            }
        }
        return null;
    }
    public static SlotAssignmentStrategy getInstance(){
        if(slotAssignmentStrategy == null){
            synchronized ((SlotAssignmentStrategy.class)){
                if(slotAssignmentStrategy ==  null){
                    slotAssignmentStrategy = new findNearestParkingSlot();
                }
            }
        }
        return slotAssignmentStrategy;
    }
}
