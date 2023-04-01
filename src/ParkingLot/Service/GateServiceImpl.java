package ParkingLot.Service;

import ParkingLot.Models.Gate;
import ParkingLot.Models.GateType;
import ParkingLot.Models.Operator;
import ParkingLot.Repository.GateRepository;
import ParkingLot.Repository.GateRepositoryImpl;

public class GateServiceImpl implements  GateService{

    private static GateService gateService;
    private GateRepository gateRepository;
    private OperatorService operatorService;

    public GateServiceImpl() {
        this.gateRepository = GateRepositoryImpl.getInstance();
        this.operatorService = OperatorServiceImpl.getInstance();
    }

    @Override
    public void saveGate(long gateId , GateType gateType, long operatorId) {
        operatorService = OperatorServiceImpl.getInstance();
        Operator operator=  operatorService.getOperator(gateId);
        Gate gate = new Gate();
        gate.setId(gateId);
        gate.setGateType(gateType);
        gate.setOperator(operator);
        gateRepository.saveGate(gateId, gate);
    }
    @Override
    public Gate getGate(long gateId) {
        return gateRepository.getGate(gateId);
    }

    public static GateService gateService(){
        if(gateService == null){
            synchronized ((GateService.class)){
                if(gateService == null) {
                    gateService = new GateServiceImpl();
                }
            }
        }
        return gateService;
    }
}
