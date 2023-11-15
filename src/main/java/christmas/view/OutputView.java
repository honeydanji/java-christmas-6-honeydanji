package christmas.view;

import java.util.HashMap;

import static christmas.utils.OutputMessage.*;

public class OutputView {

    public void outputPreview(int reservationDate) {
        System.out.println(String.format(PREVIEW.getMessage(), reservationDate));
    }

    public void outputMenu(HashMap<String, Integer> foodAndAmount) {
        System.out.print(ORDER_MENU.getMessage());

        for(String food : foodAndAmount.keySet()) {
            System.out.println(String.format(MENU.getMessage(),food,foodAndAmount.get(food)));
        }
    }

    public void outputNotDiscountPayment(int total) {
        System.out.println(String.format(NOT_DISCOUNT_PAYMENT.getMessage(), total));
    }

    public void outputGift(int gift) {
        System.out.println(GIFT_MENU.getMessage());
        if(gift == 25000) {
            System.out.println(GIFT.getMessage());
            return;
        }
        System.out.println(NOT_THING.getMessage());
    }

    public void outputBenefitDetail() {
        System.out.println(BENEFIT_DETAIL.getMessage());
    }

    public void outputChristmasDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(CHRISTMAS_DISCOUNT.getMessage(),discount));
        }
    }
    public void outputWeekdayDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(WEEKDAY_DISCOUNT.getMessage(),discount));
        }
    }
    public void outputWeekendDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(WEEKEND_DISCOUNT.getMessage(),discount));
        }
    }
    public void outputSpecialDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(SPECIAL_DISCOUNT.getMessage(),discount));
        }
    }
    public void outputGiveawayDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(GIVEAWAY_DISCOUNT.getMessage(),discount));
        }
    }

    public void outputTotalBenefit(int totalBenefit) {
        if (totalBenefit == 0) {
            System.out.println(String.format(TOTAL_BENEFIT.getMessage(),"",totalBenefit));
            System.out.println();
            return;
        }
        System.out.println(String.format(TOTAL_BENEFIT.getMessage(),"-",totalBenefit));
        System.out.println();
    }

    public void outputDiscountPayment(int total) {
        System.out.println(String.format(DISCOUNT_PAYMENT.getMessage(),total));
        System.out.println();
    }

    public void outputBadgeOfBenefit(String badge) {
        System.out.println(String.format(EVENT_BADGE.getMessage(),badge));
    }

    public void outputNotThing() {
        System.out.println(NOT_THING.getMessage());
    }
}
