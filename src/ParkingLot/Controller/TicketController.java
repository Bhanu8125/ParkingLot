package ParkingLot.Controller;

import ParkingLot.Dto.TicketGenerateRequestDto;
import ParkingLot.Dto.TicketGenerateResponseDto;
import ParkingLot.Dto.TicketResponseStatus;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.VehicleSize;
import ParkingLot.Models.VehicleType;
import ParkingLot.Service.TicketService;
import ParkingLot.Service.TicketServiceImpl;

public class TicketController {
    private TicketService ticketService;
    public TicketController() {
        this.ticketService = new TicketServiceImpl();
    }
    public TicketGenerateResponseDto generateTicket(TicketGenerateRequestDto ticketGenerateRequestDto){

        VehicleType vehicleType = VehicleEssentials.getVehicleType(ticketGenerateRequestDto.getVehicleType());
        VehicleSize vehicleSize = VehicleEssentials.getVehicleSize(ticketGenerateRequestDto.getVehicleSize());

        String vehicleNumber = ticketGenerateRequestDto.getVehicleNumber();
        long gateId = ticketGenerateRequestDto.getGateId();
        Ticket ticket = ticketService.generateTicket(vehicleNumber, gateId, vehicleType, vehicleSize);

        TicketGenerateResponseDto ticketGenerateResponseDto = new TicketGenerateResponseDto();
        ticketGenerateResponseDto.setTicket(ticket);

        if(ticket==null) ticketGenerateResponseDto.setTicketResponseStatus(TicketResponseStatus.FAILURE);
        else ticketGenerateResponseDto.setTicketResponseStatus(TicketResponseStatus.SUCCESS);

        return ticketGenerateResponseDto;
    }

}
