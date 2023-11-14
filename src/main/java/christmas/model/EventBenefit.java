package christmas.model;

import java.util.HashMap;
import java.util.List;

public class EventBenefit {
    private int reservationDate;
    private HashMap<String, Integer> foodAndAmount;
    private int totalPayment;

    public EventBenefit(int reservationDate, HashMap<String, Integer> foodAndAmount, int totalPayment) {
        this.reservationDate = reservationDate;
        this.foodAndAmount = foodAndAmount;
        this.totalPayment = totalPayment;
    }

    public boolean gift() {
        if (totalPayment >= 120000) {
            return true;
        }
        return false;
    }

    public int christmasDiscount() {
        int discount = 0;
        if (christmasPeriod().contains(reservationDate)) {
            discount = 1000 + 100 * (reservationDate - 1);
            return discount;
        }
        return discount;
    }

    private List<Integer> christmasPeriod() {
        List<Integer> christmasPeriod = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25);
        return christmasPeriod;
    }

}
