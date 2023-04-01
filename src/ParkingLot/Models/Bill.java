package ParkingLot.Models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Bill extends  BaseClass{
    private Ticket ticket;
    private LocalDateTime entryTime;

    private LocalDateTime exitTime;
    private int parkingCharge;
    private List<PaymentType> payments;
    private BillStatus billStatus;

    private Operator operator;

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<PaymentType> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentType> payments) {
        this.payments = payments;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public int getParkingCharge() {
        return parkingCharge;
    }

    public void setParkingCharge(int parkingCharge) {
        this.parkingCharge = parkingCharge;
    }
}
