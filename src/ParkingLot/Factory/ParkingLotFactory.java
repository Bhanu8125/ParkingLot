package ParkingLot.Factory;
import ParkingLot.Models.*;
import ParkingLot.Repository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotFactory {
    private ParkingLot parkingLot;
    private static ParkingLotFactory parkingLotFactory;
    List<List<ParkingSlot>> parkingSlots;
    List<ParkingFloor> parkingFloors;
    List<Gate> gates;
    List<Operator> operators;
    private ParkingLotFactory() {
        this.parkingLot = new ParkingLot();
        this.parkingFloors = new ArrayList<>();
        this.parkingSlots = new ArrayList<>();
        this.operators = new ArrayList<>();
        this.gates = new ArrayList<>();
        addParkingFloors();
        addParkingSlots();
        addOperators();
        addGates();
        parkingLot.setName("Space ParkingLot");
        parkingLot.setAddress("HSR Layout, Bangalore");
        parkingLot.setParkingFloors(parkingFloors);
        parkingLot.setGates(gates);
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        ParkingLotRepository parkingLotRepository = ParkingLotRepositoryImpl.getInstance();
        //parkingLotRepository.loadParkingLot();
        parkingLotRepository.setParkingFloors(parkingFloors);
        parkingLotRepository.setParkingSlots(parkingSlots);
    }
    public void addParkingSlots(){
        for(int i=0;i<parkingFloors.size();i++){
            parkingSlots.add(new ArrayList<ParkingSlot>());
            for(int j=1;j<=10;j++){
                ParkingSlot parkingSlot = createObject(Long.valueOf((i*100)+ j), VehicleSize.Bicycle, Arrays.asList(VehicleType.Fuel,
                        VehicleType.Electric), parkingFloors.get(i), ParkingState.Available);

                parkingSlots.get(i).add(parkingSlot);
            }
            for(int j=11;j<=20;j++){
                ParkingSlot parkingSlot = createObject(Long.valueOf((i*100)+ j), VehicleSize.Two_Wheeler, Arrays.asList(VehicleType.Fuel,
                        VehicleType.Electric), parkingFloors.get(i), ParkingState.Available);
                parkingSlots.get(i).add(parkingSlot);
            }

            for(int j=21;j<=30;j++){
                ParkingSlot parkingSlot = createObject(Long.valueOf((i*100)+ j), VehicleSize.Four_Wheeler, Arrays.asList(VehicleType.Fuel,
                        VehicleType.Electric), parkingFloors.get(i), ParkingState.Available);
                parkingSlots.get(i).add(parkingSlot);
            }

            for(int j=31;j<=40;j++){
                ParkingSlot parkingSlot = createObject(Long.valueOf((i*100)+ j), VehicleSize.Heavy, Arrays.asList(VehicleType.Fuel,
                        VehicleType.Electric), parkingFloors.get(i), ParkingState.Available);
                parkingSlots.get(i).add(parkingSlot);
            }

            for(int j=41;j<=50;j++){
                ParkingSlot parkingSlot = createObject(Long.valueOf((i*100)+ j), VehicleSize.Bicycle, Arrays.asList(VehicleType.Fuel, VehicleType.Electric),
                        parkingFloors.get(i), ParkingState.Available);

                parkingSlots.get(i).add(parkingSlot);
            }
            for(int j=51;j<=60;j++){
                ParkingSlot parkingSlot = createObject(Long.valueOf((i*100)+ j), VehicleSize.Two_Wheeler, Arrays.asList(VehicleType.Fuel, VehicleType.Electric),
                        parkingFloors.get(i), ParkingState.Available);

                parkingSlots.get(i).add(parkingSlot);
            }

            for(int j=61;j<=70;j++){
                ParkingSlot parkingSlot = createObject(Long.valueOf((i*100)+ j), VehicleSize.Four_Wheeler, Arrays.asList(VehicleType.Fuel, VehicleType.Electric),
                        parkingFloors.get(i), ParkingState.Available);
                parkingSlots.get(i).add(parkingSlot);
            }

            for(int j=71;j<=80;j++){
                ParkingSlot parkingSlot = createObject(Long.valueOf((i*100)+ j), VehicleSize.Heavy, Arrays.asList(VehicleType.Fuel, VehicleType.Electric), parkingFloors.get(i), ParkingState.Available);
                parkingSlots.get(i).add(parkingSlot);
            }
            parkingFloors.get(i).setParkingSlotList(parkingSlots.get(i));
        }
    }
    public ParkingSlot createObject(long id, VehicleSize vehicleSize, List<VehicleType> vehicleType, ParkingFloor parkingFloor, ParkingState parkingState){
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setId(id);
        parkingSlot.setSupportedVehicleSize(vehicleSize);
        parkingSlot.setSupportedVehicleType(vehicleType);
        parkingSlot.setParkingFloor(parkingFloor);
        parkingSlot.setParkingState(ParkingState.Available);

        return parkingSlot;
    }
    public List<ParkingFloor> addParkingFloors(){
        parkingFloors = new ArrayList<>();
        for(int i=0;i<4;i++){
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setParkingFloorId(i);
            parkingFloor.setParkingState(ParkingState.Available);
            parkingFloors.add(parkingFloor);
        }
        return parkingFloors;
    }

    public void addGates(){
        GateRepository gateRepository = GateRepositoryImpl.getInstance();
        for(int i=1;i<=3;i++)
        {
            Gate gate = new Gate();
            gate.setGateType(GateType.Entry);
            gate.setId(1000*i);
            gate.setOperator(operators.get(i-1));
            gates.add(gate);
            gateRepository.saveGate(1000*i, gate);
        }

        for(int i=4;i<=6;i++)
        {
            Gate gate = new Gate();
            gate.setGateType(GateType.Exit);
            gate.setId(1000*i);
            gate.setOperator(operators.get(i-1));
            gates.add(gate);
            gateRepository.saveGate(1000*i, gate);
        }
    }
    public void addOperators(){
        OperatorRepository operatorRepository = OperatorRepositoryImpl.getInstance();
        for(int i=1;i<=6;i++){
            Operator operator = new Operator();
            operator.setId(1000*i);
            operator.setName("Operator_"  + i);
            operators.add(operator);
            operatorRepository.saveOperator(1000*i, operator);
        }
    }

    public List<List<ParkingSlot>> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<List<ParkingSlot>> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public static ParkingLotFactory getInstance(){
        if(parkingLotFactory==null){
            synchronized (ParkingLotFactory.class){
                if(parkingLotFactory ==  null){
                    parkingLotFactory = new ParkingLotFactory();
                }
            }
        }
        return parkingLotFactory;
    }
}
