package ParkingLot.Repository;

import ParkingLot.Models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepositoryImpl implements TicketRepository{
    private Map<Long, Ticket> tickets;
    private long ticketId;

    private static TicketRepository ticketRepository;
    private TicketRepositoryImpl() {
        this.tickets = new HashMap<>();
        this.ticketId = 1000L;
    }

    @Override
    public long saveTicket(Ticket ticket) {
        long curr_ticketId = ticketId;
        this.tickets.put(curr_ticketId, ticket);
        ticketId++;
        return curr_ticketId;
    }
    @Override
    public Ticket getTicket(long ticketId) {
        return tickets.get(ticketId);
    }

    public static TicketRepository getInstance(){
        if(ticketRepository==null){
            synchronized (TicketRepository.class){
                if(ticketRepository ==  null){
                    ticketRepository = new TicketRepositoryImpl();
                }
            }
        }
        return ticketRepository;
    }
}
