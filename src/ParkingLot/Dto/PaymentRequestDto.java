package ParkingLot.Dto;

import ParkingLot.Models.Operator;

public class PaymentRequestDto {
    private long ticketId;
    private Operator operator;
    private CashPaymentMode cashPaymentMode;
    private OnlinePaymentMode onlinePaymentMode;
    private BalancedCardPaymentMode balancedCardPaymentMode;

    public PaymentRequestDto() {
        this.cashPaymentMode = new CashPaymentMode();
        this.onlinePaymentMode = new OnlinePaymentMode();
        this.balancedCardPaymentMode = new BalancedCardPaymentMode();
    }

    public CashPaymentMode getCashPaymentMode() {
        return cashPaymentMode;
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public void setCashPaymentMode(CashPaymentMode cashPaymentMode) {
        this.cashPaymentMode = cashPaymentMode;
    }

    public OnlinePaymentMode getOnlinePaymentMode() {
        return onlinePaymentMode;
    }

    public void setOnlinePaymentMode(OnlinePaymentMode onlinePaymentMode) {
        this.onlinePaymentMode = onlinePaymentMode;
    }

    public BalancedCardPaymentMode getBalancedCardPaymentMode() {
        return balancedCardPaymentMode;
    }

    public void setBalancedCardPaymentMode(BalancedCardPaymentMode balancedCardPaymentMode) {
        this.balancedCardPaymentMode = balancedCardPaymentMode;
    }


    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
