package ParkingLot.Repository;

import ParkingLot.Models.Payment;
import ParkingLot.Models.PaymentType;

import java.util.HashMap;

public class PaymentRepositoryImpl implements  PaymentRepository{
    private HashMap<Long, Payment> payments;
    private static PaymentRepository paymentRepository;
    public PaymentRepositoryImpl() {
        this.payments = new HashMap<>();
    }
    @Override
    public PaymentRepositoryStatus savePayment(long ticketId, Payment payment) {
        payments.put(ticketId, payment);
        return PaymentRepositoryStatus.SAVED;
    }

    @Override
    public int getPaidAmount(long ticketId) {
        if(!payments.containsKey(ticketId)) return 0;
        return payments.get(ticketId).getPaidAmount();
    }
    public static PaymentRepository getInstance(){
        if(paymentRepository==null){
            synchronized (PaymentRepository.class){
                if(paymentRepository ==  null){
                    paymentRepository = new PaymentRepositoryImpl();
                }
            }
        }
        return paymentRepository;
    }
}
