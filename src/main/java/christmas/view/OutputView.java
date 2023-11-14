package christmas.view;

import java.util.HashMap;
import java.util.List;

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
        if(gift == 25000) {
            System.out.println(GIFT_MENU.getMessage());
            return;
        }
        System.out.println(NOT_THING.getMessage());
    }

    public void outputBenefitDetail() {
        System.out.print(BENEFIT_DETAIL.getMessage());
    }

    public void outputChristmasDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(CHRISTMAS_DISCOUNT.getMessage(),discount));
            return;
        }
    }
    public void outputWeekdayDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(WEEKDAY_DISCOUNT.getMessage(),discount));
            return;
        }
    }
    public void outputWeekendDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(WEEKEND_DISCOUNT.getMessage(),discount));
            return;
        }
    }
    public void outputSpecialDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(SPECIAL_DISCOUNT.getMessage(),discount));
            return;
        }
    }
    public void outputGiveawayDiscount(int discount) {
        if (discount >= 1) {
            System.out.println(String.format(GIVEAWAY_DISCOUNT.getMessage(),discount));
            return;
        }
    }
}
