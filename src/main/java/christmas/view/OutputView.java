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
}
