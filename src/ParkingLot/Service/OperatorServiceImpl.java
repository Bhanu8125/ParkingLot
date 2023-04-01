package ParkingLot.Service;

import ParkingLot.Models.Operator;
import ParkingLot.Repository.OperatorRepository;
import ParkingLot.Repository.OperatorRepositoryImpl;

public class OperatorServiceImpl implements  OperatorService{
    private OperatorRepository operatorRepository;
    private static OperatorService operatorService;
    @Override
    public Operator saveOperator(long operatorId, String operatorName) {
        Operator operator = new Operator();
        operator.setName(operatorName);
        operator.setId(operatorId);

        //operator.setId(operatorRepository.saveOperator(operator));
        operatorRepository.saveOperator(operatorId, operator);
        return operator;
    }

    @Override
    public Operator getOperator(long operatorId) {
        return operatorRepository.getOperator(operatorId);
    }

    public static  OperatorService getInstance(){
        if(operatorService == null){
            synchronized ((OperatorServiceImpl.class)){
                if(operatorService == null){
                    operatorService = new OperatorServiceImpl();
                }
            }
        }
        return operatorService;
    }
}
