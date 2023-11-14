package christmas.model;

import java.util.HashMap;

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
    // 할인 금액
    // 혜택 금액
    // 뱃지
    // 최종 결제 금액
}
