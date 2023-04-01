package ParkingLot.Service;

import ParkingLot.Models.*;
import ParkingLot.Repository.BillRepository;
import ParkingLot.Repository.BillRepositoryImpl;
import ParkingLot.Repository.TicketRepository;
import ParkingLot.Repository.TicketRepositoryImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillServiceImpl implements  BillService{
    private static  BillService billService;
    private TicketRepository ticketRepository;
    private BillRepository billRepository;

    private  BillServiceImpl() {
        this.ticketRepository = TicketRepositoryImpl.getInstance();
        this.billRepository = BillRepositoryImpl.getInstance();
    }

    @Override
    public Bill generateBill(long ticketId, LocalDateTime entryTime, LocalDateTime exitTime, Operator operator, List<PaymentType> payments) {
        Ticket ticket = ticketRepository.getTicket(ticketId);
        System.out.println("ENTRY Time in get Generate Bill : "+ entryTime);
        System.out.println("EXIT Time in get Generate Bill : "+ exitTime);

        Bill bill = new Bill();
        bill.setTicket(ticket);
        bill.setEntryTime(ticket.getEntryTime());
        bill.setExitTime(exitTime);
        bill.setOperator(operator);
        bill.setPayments(payments);

        long billId = billRepository.saveBill(bill);
        bill.setId(billId);
        bill.setBillStatus(BillStatus.PAID);
        return  bill;
    }

    @Override
    public Bill getBill(long billId) {
        return billRepository.getBill(billId);
    }

    @Override
    public Bill searchForBill(long ticketId) {
        HashMap<Long, Bill> billMap = billRepository.getBillMap();
        Ticket ticket = ticketRepository.getTicket(ticketId);
        for(Map.Entry<Long,Bill> bill : billMap.entrySet()){
            if(bill.getValue().getTicket().equals(ticket)){
//                System.out.println("Bill Id : " + bill.getValue().getId());
//                System.out.println("Entry Time : "  + bill.getValue().getEntryTime());
//                System.out.println("Exit Time : " + bill.getValue().getExitTime());
//                System.out.println("Bill Status  : " + bill.getValue().getBillStatus());
//                System.out.println("Vehicle Type : " + bill.getValue().getTicket().getVehicle().getVehicleType());
//                System.out.println("Vehicle Size : " + bill.getValue().getTicket().getVehicle().getVehicleSize());
                return bill.getValue();
            }
        }
        return null;
    }


    public static BillService getInstance(){
        if(billService == null){
            synchronized ((BillService.class)){
                if(billService == null) {
                    billService = new BillServiceImpl();
                }
            }
        }
        return billService;
    }
}
