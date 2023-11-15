package christmas.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EventBenefit {
    private final int MIN_ORDER_AMOUNT_FOR_EVENT = 10000;
    private final int MIN_ORDER_AMOUNT_FOR_GIFT = 120000;
    private final int CHAMPAGNE_PRICE = 25000;
    private final int D_DAY_BASIC_DISCOUNT = 1000;
    private final int D_DAY_ADDITIONAL_DISCOUNT = 100;
    private final int SPECIAL_DISCOUNT = 1000;
    private final int WEEKDAY_DISCOUNT = 2023;
    private final int WEEKEND_DISCOUNT = 2023;

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

    public int totalBenefit() {
        int totalBenefit = 0;
        for (int benefit : allBenefitDetail) {
            totalBenefit += benefit;
        }
        return totalBenefit;
    }

    public List<Integer> getAllBenefitDetail() {
        allBenefitDetail = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        allBenefitDetail.add(0,christmasDiscount());
        allBenefitDetail.add(1,weekdayDiscount());
        allBenefitDetail.add(2,weekendDiscount());
        allBenefitDetail.add(3,specialDayDiscount());
        allBenefitDetail.add(4,gift());
        if(totalPayment < MIN_ORDER_AMOUNT_FOR_EVENT) {
            allBenefitDetail = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        }
        return allBenefitDetail;
    }

    public int christmasDiscount() {
        int discount = 0;
        if (decemberEventData.christmasPeriod().contains(reservationDate)) {
            discount = D_DAY_BASIC_DISCOUNT + D_DAY_ADDITIONAL_DISCOUNT * (reservationDate - 1);
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
        discount = WEEKDAY_DISCOUNT * desertCount;
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
        discount = WEEKEND_DISCOUNT * mainDishCount;
        return discount;
    }

    public int specialDayDiscount() {
        if (decemberEventData.specialDay().contains(reservationDate)) {
            return SPECIAL_DISCOUNT;
        }
        return 0;
    }

    public int gift() {
        if (totalPayment >= MIN_ORDER_AMOUNT_FOR_GIFT) {
            return CHAMPAGNE_PRICE;
        }
        return 0;
    }
}
