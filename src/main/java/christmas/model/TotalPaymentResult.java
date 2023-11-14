package christmas.model;

import java.util.HashMap;

public class TotalPaymentResult {

    public int getTotalPayment(HashMap<String, Integer> foodAndAmount) {
        int total = 0;
        for(String food : foodAndAmount.keySet()) {
            total += CalculateTotalPayment.valueOf(food).price(foodAndAmount.get(food));
        }
        return total;
    }
}
