package ParkingLot.Repository;

import ParkingLot.Models.Payment;
import ParkingLot.Models.PaymentType;

public interface PaymentRepository {
    PaymentRepositoryStatus savePayment(long ticket, Payment payment);
    int getPaidAmount(long ticktId);
}
