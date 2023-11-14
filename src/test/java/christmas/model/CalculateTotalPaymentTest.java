package christmas.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class CalculateTotalPaymentTest {

    @Test
    void 총_주문_금액_계산_테스트() {
        HashMap<String, Integer> foodAndAmount = new HashMap<>();
        foodAndAmount.put("티본스테이크",1);
        foodAndAmount.put("바비큐립",1);
        foodAndAmount.put("시저샐러드",1);
        foodAndAmount.put("초코케이크",1);
        foodAndAmount.put("샴페인",1);
        int total = 0;
        for (String s : foodAndAmount.keySet()) {
            total += CalculateTotalPayment.valueOf(s).price(foodAndAmount.get(s));
        }
        assertEquals(157000,total);
    }
}
