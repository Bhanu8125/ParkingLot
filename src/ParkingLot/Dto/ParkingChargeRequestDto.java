package ParkingLot.Dto;

import ParkingLot.Models.Operator;

public class ParkingChargeRequestDto {
    private long ticketid;
    private long surge;

    public long getSurge() {
        return surge;
    }
    public void setSurge(long surge) {
        this.surge = surge;
    }
    public long getTicketid() {
        return ticketid;
    }
    public void setTicketid(long ticketid) {
        this.ticketid = ticketid;
    }
}
