package ParkingLot.Service;

import ParkingLot.Models.Gate;
import ParkingLot.Models.GateType;

public interface GateService {
    void saveGate(long gateId, GateType gateType, long operatorId);
    Gate getGate(long gateId);
}
