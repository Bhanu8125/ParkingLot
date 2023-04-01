package ParkingLot.Dto;

import ParkingLot.Models.Bill;

public class BillResponseDto {
    private Bill bill;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
