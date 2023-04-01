package ParkingLot.Service;

import ParkingLot.Models.*;
import ParkingLot.Repository.ParkingLotRepositoryImpl;
import ParkingLot.Repository.TicketRepository;
import ParkingLot.Repository.TicketRepositoryImpl;
import ParkingLot.Strategy.SlotAssigment.SlotAssignmentStrategy;
import ParkingLot.Strategy.SlotAssigment.findNearestParkingSlot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketServiceImpl implements  TicketService{
    private TicketRepository ticketRepository;
    private VehicleService vehicleService;
    private GateService gateService;
    private Operator operator;
    private SlotAssignmentStrategy slotAssignmentStrategy;

    public TicketServiceImpl() {
        this.ticketRepository = TicketRepositoryImpl.getInstance();
        this.vehicleService = VehicleServiceImpl.getInstance();
        this.gateService = GateServiceImpl.gateService();
        this.slotAssignmentStrategy = findNearestParkingSlot.getInstance();
    }
    @Override
    public Ticket generateTicket(String vehicleNumber, long gateId, VehicleType vehicleType, VehicleSize vehicleSize) {
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);
        if(vehicle ==  null){
            vehicle = vehicleService.saveVehicle(vehicleNumber, vehicleType, vehicleSize);
        }
        Gate gate = gateService.getGate(gateId);
        operator = gate.getOperator();
        ParkingSlot parkingSlot = slotAssignmentStrategy.assignParkingSlot(vehicleType, vehicleSize);
        if(parkingSlot == null) return null;

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setVehicle(vehicle);
        String str = "2023-03-31 11:30:40";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        ticket.setEntryTime(dateTime);
        ticket.setParkingSlot(parkingSlot);
        ticket.setId(ticketRepository.saveTicket(ticket));
        return ticket;
    }

    @Override
    public Ticket getTicket(long ticketId) {
        return ticketRepository.getTicket(ticketId);
    }
}
