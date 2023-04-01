package ParkingLot.Dto;

import ParkingLot.Models.PaymentType;

public class CashPaymentMode {
    private int paidAmount;
    private PaymentType paymentType;

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
