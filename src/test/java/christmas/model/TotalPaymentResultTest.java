package christmas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class TotalPaymentResultTest {


    TotalPaymentResult totalPaymentResult;

    @BeforeEach
    public void beforeEach() {
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        totalPaymentResult = new TotalPaymentResult(foodAndAmountTest);
    }

    @Test
    void 증점품이_있을_경우_할인전_예상금액() {
        int totalAmountBeforeBenefits = 120000;
        int totalBenefit = 30000;

        assertEquals(115000, totalPaymentResult.estimatePaymentAfterDiscount(totalAmountBeforeBenefits, totalBenefit));
    }

    @Test
    void 증점품이_없을_경우_할인전_예상금액() {
        int totalAmountBeforeBenefits = 110000;
        int totalBenefit = 30000;

        assertEquals(80000, totalPaymentResult.estimatePaymentAfterDiscount(totalAmountBeforeBenefits, totalBenefit));
    }
}
