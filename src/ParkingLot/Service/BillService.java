package ParkingLot.Service;

import ParkingLot.Models.*;

import java.time.LocalDateTime;
import java.util.List;

public interface BillService {
    Bill generateBill(long ticketId, LocalDateTime entryTime, LocalDateTime exitTime, Operator operator , List<PaymentType> payments);
    Bill getBill(long billId);

    Bill searchForBill(long ticketId);

}
