package ParkingLot.Repository;

import ParkingLot.Models.Operator;

public interface OperatorRepository {
    void saveOperator(long OperatorId, Operator operator);
    Operator getOperator(long operatorId);

}
