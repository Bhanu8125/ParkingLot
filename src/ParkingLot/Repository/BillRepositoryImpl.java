package ParkingLot.Repository;

import ParkingLot.Models.Bill;

import java.util.HashMap;

public class BillRepositoryImpl implements  BillRepository{

    private HashMap<Long, Bill> billMap = new HashMap<>();
    private long billId;

    private static  BillRepository billRepository;

    public BillRepositoryImpl() {
        this.billMap = new HashMap<>();
        this.billId = 1000L;
    }

    @Override
    public long saveBill(Bill bill) {
        long curr_billId = billId;
        billMap.put(curr_billId, bill);
        billId++;
        return curr_billId;
    }

    @Override
    public HashMap<Long, Bill> getBillMap() {
        return billMap;
    }

    @Override
    public Bill getBill(long billId) {
        return billMap.get(billId);
    }

    public static BillRepository getInstance(){
        if(billRepository == null){
            synchronized (BillRepository .class){
                if(billRepository  ==  null){
                    billRepository  = new BillRepositoryImpl();
                }
            }
        }
        return billRepository;
    }
}
