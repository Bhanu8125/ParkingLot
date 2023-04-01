package ParkingLot.Controller;

import ParkingLot.Dto.ParkingChargeRequestDto;
import ParkingLot.Dto.ParkingChargeResponseDto;
import ParkingLot.Service.CalculateChargeService;
import ParkingLot.Service.CalculateChargeServiceImpl;

public class CalculateFeesController {
    private CalculateChargeService calculateChargeService;
    public CalculateFeesController(){
        this.calculateChargeService = new CalculateChargeServiceImpl();
    }

    public ParkingChargeResponseDto getParkingCharge(ParkingChargeRequestDto parkingChargeRequestDto){

        ParkingChargeResponseDto parkingChargeResponseDto = new ParkingChargeResponseDto();

        double parkingCharge = calculateChargeService.getParkingCharge(parkingChargeRequestDto.getTicketid(), parkingChargeRequestDto.getSurge());
        parkingChargeResponseDto.setParkingCharge(parkingCharge);

        return parkingChargeResponseDto;
    }

}
