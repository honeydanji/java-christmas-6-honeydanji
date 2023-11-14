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

    @Test
    void 디저트_메뉴_구입_O_평일_O_할인_테스트() {
        int reservationDateTest = 3;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("티본스테이크",2);
        foodAndAmountTest.put("초코케이크",3);
        foodAndAmountTest.put("제로콜라",5);
        int totalPaymentTest = 0;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(2023*3,eventBenefit.weekdayDiscount());
    }

    @Test
    void 디저트_메뉴_구입_X_평일_O_할인_테스트() {
        int reservationDateTest = 27;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("티본스테이크",2);
        foodAndAmountTest.put("제로콜라",5);
        int totalPaymentTest = 0;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(0,eventBenefit.weekdayDiscount());
    }

    @Test
    void 디저트_메뉴_구입_O_평일_X_할인_테스트() {
        int reservationDateTest = 1;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("티본스테이크",2);
        foodAndAmountTest.put("초코케이크",3);
        foodAndAmountTest.put("제로콜라",5);
        int totalPaymentTest = 0;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(0,eventBenefit.weekdayDiscount());
    }

    @Test
    void 메인_메뉴_구입_O_주말_O_할인_테스트() {
        int reservationDateTest = 1;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("티본스테이크",2);
        foodAndAmountTest.put("초코케이크",3);
        foodAndAmountTest.put("제로콜라",5);
        int totalPaymentTest = 0;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(2023*2,eventBenefit.weekendDiscount());
    }

    @Test
    void 메인_메뉴_구입_O_주말_X_할인_테스트() {
        int reservationDateTest = 27;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("티본스테이크",2);
        foodAndAmountTest.put("제로콜라",5);
        int totalPaymentTest = 0;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(0,eventBenefit.weekendDiscount());
    }

    @Test
    void 메인_메뉴_구입_X_주말_O_할인_테스트() {
        int reservationDateTest = 1;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("초코케이크",3);
        foodAndAmountTest.put("제로콜라",5);
        int totalPaymentTest = 0;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(0,eventBenefit.weekendDiscount());
    }
}
