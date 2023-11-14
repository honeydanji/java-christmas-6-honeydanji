package christmas.model;

import java.util.HashMap;

public class TotalPaymentResult {
    private int totalPayment;

    public TotalPaymentResult(HashMap<String, Integer> foodAndAmount) {
        if (foodAndAmount == null) {
            return;
        }
        setTotalPayment(foodAndAmount);
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    private void setTotalPayment(HashMap<String, Integer> foodAndAmount) {
        int total = 0;
        for(String food : foodAndAmount.keySet()) {
            total += CalculateTotalPayment.valueOf(food).price(foodAndAmount.get(food));
        }
        this.totalPayment = total;
    }
}
