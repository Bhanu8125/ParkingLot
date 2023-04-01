package ParkingLot;

import ParkingLot.Controller.BillController;
import ParkingLot.Controller.CalculateFeesController;
import ParkingLot.Controller.PaymentController;
import ParkingLot.Controller.TicketController;
import ParkingLot.Dto.*;
import ParkingLot.Factory.ParkingLotFactory;
import ParkingLot.Models.*;
import ParkingLot.Repository.*;

public class Client {
    public static void main(String[] args) {

        ParkingLotFactory parkingLotFactory = ParkingLotFactory.getInstance();
        /*
        Operator operator = new Operator();
        operator.setId(12234);
        operator.setName("Operator_1");

        Gate gate = new Gate();
        gate.setId(1000);
        gate.setOperator(operator);
        gate.setGateType(GateType.Entry);

        OperatorRepository operatorRepository = OperatorRepositoryImpl.getInstance();
        GateRepository gateRepository =  GateRepositoryImpl.getInstance();

        operatorRepository.saveOperator(operator);
        gateRepository.saveGate(gate);


         */

        TicketGenerateRequestDto ticketGenerateRequestDto = new TicketGenerateRequestDto();
        ticketGenerateRequestDto.setGateId(1000);
        ticketGenerateRequestDto.setOperatorId(1001);
        ticketGenerateRequestDto.setVehicleNumber("AP12B1215");
        ticketGenerateRequestDto.setVehicleType("Electric");
        ticketGenerateRequestDto.setVehicleSize("Four Wheeler");

        TicketController ticketController =  new TicketController();
        TicketGenerateResponseDto ticketGenerateResponseDto = ticketController.generateTicket(ticketGenerateRequestDto);

        long ticketId = ticketGenerateResponseDto.getTicket().getId();
        System.out.println("Ticket Id : " + ticketId);
        System.out.println("Ticket Response :  " + ticketGenerateResponseDto.getTicketResponseStatus());

        System.out.println("-------------------------------------------------------------------------------");
        TicketRepository  ticketRepo = TicketRepositoryImpl.getInstance();
        Ticket ticket =  ticketRepo.getTicket(ticketId);

        System.out.println(ticket.getId());
        System.out.println(ticket.getVehicle().getVehicleNumber());
        System.out.println(ticket.getVehicle().getVehicleSize());
        System.out.println(ticket.getVehicle().getVehicleType());

        ParkingChargeRequestDto parkingChargeRequestDto = new ParkingChargeRequestDto();
        parkingChargeRequestDto.setSurge(1L);
        parkingChargeRequestDto.setTicketid(ticketId);

        CalculateFeesController calculateFeesController = new CalculateFeesController();
        ParkingChargeResponseDto  parkingChargeResponseDto = calculateFeesController.getParkingCharge(parkingChargeRequestDto);

        double amount  = parkingChargeResponseDto.getParkingCharge();
        System.out.println("Parking Fee : "  + amount);

        System.out.println("-------------------------------------------------------------------------------");

        Operator operator = new Operator();
        operator.setId(1002);
        operator.setName("Operator_2");

        CashPaymentMode cashPaymentMode = new CashPaymentMode();
        cashPaymentMode.setPaidAmount(1000);
        cashPaymentMode.setPaymentType(PaymentType.CASH);

        OnlinePaymentMode onlinePaymentMode = new OnlinePaymentMode();
        onlinePaymentMode.setPaymentType(PaymentType.ONLINE);
        onlinePaymentMode.setPaidAmount(1000);

        BalancedCardPaymentMode balancedCardPaymentMode = new BalancedCardPaymentMode();
        balancedCardPaymentMode.setPaidAmount(1600);
        balancedCardPaymentMode.setPaymentType(PaymentType.BALANCE_CARD);


        PaymentRequestDto paymentRequestDto = new PaymentRequestDto();
        paymentRequestDto.setTicketId(ticketId);
        paymentRequestDto.setOperator(operator);
        paymentRequestDto.setBalancedCardPaymentMode(balancedCardPaymentMode);
        paymentRequestDto.setCashPaymentMode(cashPaymentMode);
        paymentRequestDto.setOnlinePaymentMode(onlinePaymentMode);


        PaymentController paymentController = new PaymentController();
        PaymentResponseDto paymentResponseDto = paymentController.doPayment((int)amount, paymentRequestDto);

        System.out.println("Payment Status : " + paymentResponseDto.getPaymentStatus());
        System.out.println(paymentResponseDto.getPaymentResponse());
        System.out.println("-------------------------------------------------------------------------------");
        BillRequestDto billRequestDto = new BillRequestDto();
        billRequestDto.setTicketId(ticketId);

        BillController billController = new BillController();
        BillResponseDto  billResponseDto =  billController.getBill(billRequestDto);
        Bill bill = billResponseDto.getBill();

        System.out.println("Bill Id : " + bill.getId());
        System.out.println("Entry Time : "  + bill.getEntryTime());
        System.out.println("Exit Time : " + bill.getExitTime());
        System.out.println("Bill Status  : " + bill.getBillStatus());
        System.out.println("Vehicle Type : " + bill.getTicket().getVehicle().getVehicleType());
        System.out.println("Vehicle Size : " + bill.getTicket().getVehicle().getVehicleSize());
    }
}
