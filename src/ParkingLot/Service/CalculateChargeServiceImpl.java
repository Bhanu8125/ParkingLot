package ParkingLot.Service;

import ParkingLot.Factory.FeesCalculationFactory;
import ParkingLot.Models.*;
import ParkingLot.Repository.TicketRepository;
import ParkingLot.Repository.TicketRepositoryImpl;
import ParkingLot.Strategy.FeesCalculation.FeesCalculationStrategy;

import java.time.LocalDateTime;

public class CalculateChargeServiceImpl implements  CalculateChargeService{
    private TicketRepository ticketRepository;
    private FeesCalculationStrategy feesCalculationStrategy;


    public CalculateChargeServiceImpl() {
        this.ticketRepository = TicketRepositoryImpl.getInstance();
    }

    @Override
    public double getParkingCharge(long ticketId, long surge) {
        Ticket ticket = ticketRepository.getTicket(ticketId);
        //System.out.println(ticket);
        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        VehicleSize vehicleSize = ticket.getVehicle().getVehicleSize();
        feesCalculationStrategy = FeesCalculationFactory.getFeesCalculationStrategyInstance(vehicleSize);
        LocalDateTime exitTime = LocalDateTime.now();
       // System.out.println("ENTRY Time in get Parking Charge : "+ ticket.getEntryTime());
       // System.out.println("EXIT Time in get Parking Charge : "+ exitTime);
        double parkingCharge =  feesCalculationStrategy.calculateFees(vehicleType, ticket.getEntryTime(), exitTime, surge);
        return parkingCharge;
    }
}
