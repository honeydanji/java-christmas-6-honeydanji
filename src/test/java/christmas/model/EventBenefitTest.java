package christmas.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class EventBenefitTest {

    private EventBenefit eventBenefit;

    @Test
    void 총주문_금액_120000_이상인_경우_증정품_테스트() {
        int reservationDateTest = 15;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        int totalPaymentTest = 120000;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(true,eventBenefit.gift());
    }

    @Test
    void 총주문_금액_120000_미만인_경우_증정품_테스트() {
        int reservationDateTest = 15;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        int totalPaymentTest = 110000;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(false,eventBenefit.gift());
    }

}
