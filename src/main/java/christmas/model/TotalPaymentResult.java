package christmas.model;

import java.util.HashMap;

public class TotalPaymentResult {
    private final int MIN_ORDER_AMOUNT_FOR_GIFT = 120000;
    private final int CHAMPAGNE_PRICE = 25000;

    private int totalPayment;

    public TotalPaymentResult(HashMap<String, Integer> foodAndAmount) {
        if (foodAndAmount == null) {
            return;
        }
        setTotalPayment(foodAndAmount);
    }

    public int estimatePaymentAfterDiscount(int totalAmountBeforeBenefits, int totalBenefit) {
        int totalAmountAfterBenefits = 0;
        if(totalAmountBeforeBenefits >= MIN_ORDER_AMOUNT_FOR_GIFT) {
            totalAmountAfterBenefits = totalAmountBeforeBenefits - totalBenefit + CHAMPAGNE_PRICE;
            return totalAmountAfterBenefits;
        }
        totalAmountAfterBenefits = totalAmountBeforeBenefits - totalBenefit;
        return totalAmountAfterBenefits;
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
