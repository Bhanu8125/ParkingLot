package ParkingLot.Repository;

import ParkingLot.Models.Operator;

import java.util.HashMap;

public class OperatorRepositoryImpl implements OperatorRepository{
    private HashMap<Long, Operator> operators = new HashMap<Long, Operator>();
    private static  OperatorRepository operatorRepository;
    public OperatorRepositoryImpl() {
        this.operators = new HashMap<Long, Operator>();
    }
    @Override
    public void saveOperator(long operatorId, Operator operator) {
        operators.put(operatorId, operator);
        //return operatorId;
    }
    @Override
    public Operator getOperator(long operatorId) {
        return operators.get(operatorId);
    }

    public static OperatorRepository getInstance(){
        if(operatorRepository == null){
            synchronized (OperatorRepository .class){
                if(operatorRepository  ==  null){
                    operatorRepository  = new OperatorRepositoryImpl();
                }
            }
        }
        return operatorRepository;
    }
}
