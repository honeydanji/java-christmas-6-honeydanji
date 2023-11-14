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

    public int weekdayDiscount() {
        int discount = 0;
        int desertCount = 0;
        for(String food : foodAndAmount.keySet()) {
            if (weekday().contains(reservationDate) && desert().contains(food)) {
                desertCount += foodAndAmount.get(food);
            }
        }
        discount = 2023 * desertCount;
        return discount;
    }

    private List<Integer> christmasPeriod() {
        List<Integer> christmasPeriod = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25);
        return christmasPeriod;
    }

    private List<Integer> weekday() {
        List<Integer> weekday = List.of(3,4,5,6,7,10,11,12,13,14,17,18,19,20,21,24,25,26,27,28,31);
        return weekday;
    }

    private List<String> desert() {
        List<String> desert = List.of("초코케이크", "아이스크림");
        return desert;
    }
}