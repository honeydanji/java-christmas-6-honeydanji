package christmas.model;

import static christmas.utils.OutputMessage.NOT_THING;

public class BadgeByBenefit {

    private final int STAR = 5000;
    private final int TREE = 10000;
    private final int SANTA = 20000;
    private int totalBenefit;

    public BadgeByBenefit(int totalBenefit) {
        this.totalBenefit = totalBenefit;
    }

    public String badge() {
        if (totalBenefit >= SANTA) {
            return "산타";
        }
        if (totalBenefit >= TREE) {
            return "트리";
        }
        if (totalBenefit >= STAR) {
            return "별";
        }
        return NOT_THING.getMessage();
    }
}
