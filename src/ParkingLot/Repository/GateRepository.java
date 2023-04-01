package ParkingLot.Repository;

import ParkingLot.Models.Gate;

public interface GateRepository {

    void saveGate(long gateId, Gate gate);
    Gate getGate(long gateId);
}
