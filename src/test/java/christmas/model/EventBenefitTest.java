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

        assertEquals(25000,eventBenefit.gift());
    }

    @Test
    void 총주문_금액_120000_미만인_경우_증정품_테스트() {
        int reservationDateTest = 15;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        int totalPaymentTest = 110000;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(0,eventBenefit.gift());
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

    @Test
    void 스페셜_데이_o_할인_테스트() {
        int reservationDateTest = 3;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        int totalPaymentTest = 0;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(1000,eventBenefit.specialDayDiscount());
    }

    @Test
    void 스페셜_데이_x_할인_테스트() {
        int reservationDateTest = 1;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("초코케이크",3);
        foodAndAmountTest.put("제로콜라",5);
        int totalPaymentTest = 0;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);

        assertEquals(0,eventBenefit.specialDayDiscount());
    }

    @Test
    void 혜택_내역_테스트() {
        int reservationDateTest = 3;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("티본스테이크",1);
        foodAndAmountTest.put("바비큐립",1);
        foodAndAmountTest.put("초코케이크",2);
        foodAndAmountTest.put("제로콜라",2);
        int totalPaymentTest = 142000;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);
        assertEquals(1200, eventBenefit.getAllBenefitDetail().get(0)); // 디데이
        assertEquals(4046, eventBenefit.getAllBenefitDetail().get(1)); // 평일
        assertEquals(0, eventBenefit.getAllBenefitDetail().get(2));    // 주말
        assertEquals(1000, eventBenefit.getAllBenefitDetail().get(3)); // 특별
        assertEquals(25000, eventBenefit.getAllBenefitDetail().get(4));// 증정
    }

    @Test
    void 총혜택_금액_테스트() {
        int reservationDateTest = 3;
        HashMap<String, Integer> foodAndAmountTest = new HashMap<>();
        foodAndAmountTest.put("티본스테이크",1);
        foodAndAmountTest.put("바비큐립",1);
        foodAndAmountTest.put("초코케이크",2);
        foodAndAmountTest.put("제로콜라",2);
        int totalPaymentTest = 142000;

        eventBenefit = new EventBenefit(reservationDateTest, foodAndAmountTest, totalPaymentTest);
        eventBenefit.getAllBenefitDetail();
        assertEquals(31246,eventBenefit.totalBenefit());
    }
}
