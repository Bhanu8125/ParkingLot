package ParkingLot.Service;

public interface CalculateChargeService{

    double getParkingCharge(long ticketId, long surge);
}
