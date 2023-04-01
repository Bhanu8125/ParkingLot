package ParkingLot.Dto;

import ParkingLot.Models.PaymentStatus;

public class PaymentResponseDto {
    private PaymentStatus paymentStatus;
    private String paymentResponse;

    public String getPaymentResponse() {
        return paymentResponse;
    }

    public void setPaymentResponse(String paymentResponse) {
        this.paymentResponse = paymentResponse;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
