package ParkingLot.Service;

import ParkingLot.Models.Operator;

public interface OperatorService {
    Operator saveOperator(long operatorId, String operatorName);

    Operator getOperator(long operatorId);
}
