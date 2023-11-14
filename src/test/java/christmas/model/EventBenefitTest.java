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

    @Test
    void 디데이_할인_테스트() {
        int reservationDateTest = 1;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        int totalPaymentTest = 110000;
        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(1000, eventBenefit.christmasDiscount());
    }

    @Test
    void 디데이_아닌_날_할인_테스트() {
        int reservationDateTest = 27;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        int totalPaymentTest = 110000;
        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(0,eventBenefit.christmasDiscount());
    }

}
