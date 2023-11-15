package christmas.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BadgeByBenefitTest {
    BadgeByBenefit badgeByBenefit;

    @Test
    void 혜택_금액_5천원_미만() {
        int totalBenefitTest = 0;
        badgeByBenefit = new BadgeByBenefit(totalBenefitTest);
        assertEquals("없음\n",badgeByBenefit.badge());
    }

    @Test
    void 혜택_금액_5천원_이상_별() {
        int totalBenefitTest = 5000;
        badgeByBenefit = new BadgeByBenefit(totalBenefitTest);
        assertEquals("별",badgeByBenefit.badge());
    }
    @Test
    void 혜택_금액_1만원_이상_트리() {
        int totalBenefitTest = 10000;
        badgeByBenefit = new BadgeByBenefit(totalBenefitTest);
        assertEquals("트리",badgeByBenefit.badge());
    }
    @Test
    void 혜택_금액_2만원_이상_산타() {
        int totalBenefitTest = 20000;
        badgeByBenefit = new BadgeByBenefit(totalBenefitTest);
        assertEquals("산타",badgeByBenefit.badge());
    }
}
