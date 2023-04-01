package ParkingLot.Repository;

import ParkingLot.Models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepositoryImpl implements  GateRepository{

    private Map<Long, Gate> gates;

    private static GateRepository gateRepository;

    public GateRepositoryImpl() {
        this.gates = new HashMap<Long, Gate>();
    }

    @Override
    public void saveGate(long gateId, Gate gate) {
        gates.put(gateId, gate);
    }

    @Override
    public Gate getGate(long gateId) {
        return gates.get(gateId);
    }

    public static GateRepository getInstance(){
        if(gateRepository==null){
            synchronized (GateRepository.class){
                if(gateRepository ==  null){
                    gateRepository = new GateRepositoryImpl();
                }
            }
        }
        return gateRepository;
    }
}
