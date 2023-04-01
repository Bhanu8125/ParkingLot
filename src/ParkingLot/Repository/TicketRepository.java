package ParkingLot.Repository;

import ParkingLot.Models.Ticket;

public interface TicketRepository {
    long saveTicket(Ticket ticket);
    Ticket getTicket(long ticketId);
}
