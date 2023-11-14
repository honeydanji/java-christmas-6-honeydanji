package christmas.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EventBenefit {

    private int reservationDate;
    private HashMap<String, Integer> foodAndAmount;
    private int totalPayment;
    private final DecemberEventData decemberEventData = new DecemberEventData();
    private List<Integer> allBenefitDetail;

    public EventBenefit(int reservationDate, HashMap<String, Integer> foodAndAmount, int totalPayment) {
        this.reservationDate = reservationDate;
        this.foodAndAmount = foodAndAmount;
        this.totalPayment = totalPayment;
    }

    public List<Integer> getAllBenefitDetail() {
        allBenefitDetail = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        allBenefitDetail.add(0,christmasDiscount());
        allBenefitDetail.add(1,weekdayDiscount());
        allBenefitDetail.add(2,weekendDiscount());
        allBenefitDetail.add(3,specialDayDiscount());
        allBenefitDetail.add(4,gift());
        return allBenefitDetail;
    }

    public int christmasDiscount() {
        int discount = 0;
        if (decemberEventData.christmasPeriod().contains(reservationDate)) {
            discount = 1000 + 100 * (reservationDate - 1);
            return discount;
        }
        return discount;
    }

    public int weekdayDiscount() {
        int discount = 0;
        int desertCount = 0;
        for(String food : foodAndAmount.keySet()) {
            if (decemberEventData.weekday().contains(reservationDate) && decemberEventData.desert().contains(food)) {
                desertCount += foodAndAmount.get(food);
            }
        }
        discount = 2023 * desertCount;
        return discount;
    }

    public int weekendDiscount() {
        int discount = 0;
        int mainDishCount = 0;
        for(String food : foodAndAmount.keySet()) {
            if (decemberEventData.weekend().contains(reservationDate) && decemberEventData.mainDish().contains(food)) {
                mainDishCount += foodAndAmount.get(food);
            }
        }
        discount = 2023 * mainDishCount;
        return discount;
    }

    public int specialDayDiscount() {
        if (decemberEventData.specialDay().contains(reservationDate)) {
            return 1000;
        }
        return 0;
    }

    public int gift() {
        if (totalPayment >= 120000) {
            return 25000;
        }
        return 0;
    }
}
