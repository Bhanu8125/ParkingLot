package ParkingLot.Service;

import ParkingLot.Models.Ticket;
import ParkingLot.Models.VehicleSize;
import ParkingLot.Models.VehicleType;
import ParkingLot.Repository.TicketRepository;

public interface TicketService {
    Ticket generateTicket(String vehicleNumber, long gateId, VehicleType vehicleType, VehicleSize vehicleSize);
    Ticket getTicket(long ticketid);

}
