package ParkingLot.Controller;

import ParkingLot.Dto.BillRequestDto;
import ParkingLot.Dto.BillResponseDto;
import ParkingLot.Models.Bill;
import ParkingLot.Service.BillService;
import ParkingLot.Service.BillServiceImpl;

public class BillController {
    private BillService billService;
    public BillController() {
        this.billService = BillServiceImpl.getInstance();
    }

    public BillResponseDto getBill(BillRequestDto billRequestDto){
        BillResponseDto billResponseDto = new BillResponseDto();
        Bill bill = billService.searchForBill(billRequestDto.getTicketId());
        billResponseDto.setBill(bill);

        return  billResponseDto;
    }
}
