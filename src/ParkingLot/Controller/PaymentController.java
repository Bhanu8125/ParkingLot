package ParkingLot.Controller;

import ParkingLot.Dto.*;
import ParkingLot.Models.PaymentStatus;
import ParkingLot.Models.PaymentType;
import ParkingLot.Service.PaymentService;
import ParkingLot.Service.PaymentServiceImpl;

import java.util.HashMap;

public class PaymentController {
    private PaymentService paymentService;

    public PaymentController() {
        this.paymentService = new PaymentServiceImpl();
    }

    public PaymentResponseDto doPayment(int totalAmount, PaymentRequestDto paymentRequestDto){

        //System.out.println("totalAmount....."  + totalAmount);
        CashPaymentMode cashPaymentMode = paymentRequestDto.getCashPaymentMode();
        OnlinePaymentMode onlinePaymentMode = paymentRequestDto.getOnlinePaymentMode();
        BalancedCardPaymentMode balancedCardPaymentMode = paymentRequestDto.getBalancedCardPaymentMode();

        HashMap<PaymentType,Integer> paymentTypes = new HashMap<>();
        paymentTypes.put(cashPaymentMode.getPaymentType(), cashPaymentMode.getPaidAmount());
        paymentTypes.put(onlinePaymentMode.getPaymentType(), onlinePaymentMode.getPaidAmount());
        paymentTypes.put(balancedCardPaymentMode.getPaymentType(), balancedCardPaymentMode.getPaidAmount());
        PaymentStatus paymentStatus = paymentService.payAmount(paymentRequestDto.getTicketId(),totalAmount, paymentTypes, paymentRequestDto.getOperator());

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setPaymentStatus(paymentStatus);
        if(paymentStatus.equals(PaymentStatus.FAILURE)){
            paymentResponseDto.setPaymentResponse("Payment not completed due to technical error, please retry");
        }
        else{
            paymentResponseDto.setPaymentResponse("Payment Completed, Thanks for using our services.");
        }
        return  paymentResponseDto;
    }

}
