package ParkingLot.Service;

import ParkingLot.Models.Operator;
import ParkingLot.Models.PaymentStatus;
import ParkingLot.Models.PaymentType;

import java.util.HashMap;

public interface PaymentService {
    PaymentStatus payAmount(long ticketId, int totalAmount, HashMap<PaymentType,Integer> paymentMap, Operator operator);
}
