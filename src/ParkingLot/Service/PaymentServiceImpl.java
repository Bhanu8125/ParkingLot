package ParkingLot.Service;

import ParkingLot.Models.*;
import ParkingLot.Repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentServiceImpl implements  PaymentService{
    private PaymentRepository paymentRepository;
    private BillService billService;
    private TicketRepository ticketRepository;

    public PaymentServiceImpl() {
        this.paymentRepository = PaymentRepositoryImpl.getInstance();
        this.ticketRepository = TicketRepositoryImpl.getInstance();
        this.billService = BillServiceImpl.getInstance();

    }
    @Override
    public PaymentStatus payAmount(long ticketId, int totalAmount, HashMap<PaymentType, Integer> paymentMap, Operator operator) {
        int cash = paymentMap.get(PaymentType.CASH);
        int online = paymentMap.get(PaymentType.ONLINE);
        int balanceCard = paymentMap.get(PaymentType.BALANCE_CARD);
        int totalPaid = cash + online + balanceCard;

        System.out.println("totalAmount : " + totalAmount + "   "  + "totalPaid : " +  totalPaid);

        if(totalPaid != totalAmount) return PaymentStatus.IN_COMPLETE;

        List<PaymentType> paymentType = new ArrayList<>();
        Payment payment = new Payment();
        payment.setId(ticketId);
        if(cash != 0){
            paymentType.add(PaymentType.CASH);
        }
        if(online != 0){
            paymentType.add(PaymentType.ONLINE);
        }
        if(balanceCard != 0){
            paymentType.add(PaymentType.BALANCE_CARD);
        }
        payment.setPaymentType(paymentType);
        payment.setPaidAmount(totalPaid);
        payment.setTotalAmount(totalAmount);

        PaymentRepositoryStatus  paymentRepositoryStatus = paymentRepository.savePayment(ticketId, payment);
        if(paymentRepositoryStatus.equals(PaymentRepositoryStatus.ERROR)){
            return PaymentStatus.FAILURE;
        }
        Ticket ticket = ticketRepository.getTicket(ticketId);
        billService.generateBill(ticketId, ticket.getEntryTime(), LocalDateTime.now(), operator, paymentType);
        return PaymentStatus.SUCCESS;
    }
}
