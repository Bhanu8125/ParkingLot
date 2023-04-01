package ParkingLot.Models;

import Practice.Base;

import java.util.List;

public class Payment extends BaseClass {

    int totalAmount;
    int paidAmount;
    private List<PaymentType> paymentType;
    private PaymentStatus paymentStatus;


    public List<PaymentType> getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(List<PaymentType> paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setTotalAmount(int amount) {
        this.totalAmount = amount;
    }
}
