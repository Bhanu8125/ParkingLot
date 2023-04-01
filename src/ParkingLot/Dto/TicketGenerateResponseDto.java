package ParkingLot.Dto;

import ParkingLot.Models.Ticket;

public class TicketGenerateResponseDto {
    private Ticket ticket;
    private TicketResponseStatus ticketResponseStatus;

    public TicketResponseStatus getTicketResponseStatus() {
        return ticketResponseStatus;
    }

    public void setTicketResponseStatus(TicketResponseStatus ticketResponseStatus) {
        this.ticketResponseStatus = ticketResponseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
