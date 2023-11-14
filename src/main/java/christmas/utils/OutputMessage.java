package christmas.utils;

public enum OutputMessage {

    PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    ORDER_MENU("<주문 메뉴>\n"),
    MENU("%s %d개"),
    NOT_DISCOUNT_PAYMENT("할인 전 총주문 금액\n" + "%d원"),
    GIFT_MENU("<증정 메뉴>\n" + "샴페인 %d"),
    BENEFIT_DETAIL("<혜택 내역>\n"
                    + "크리스마스 디데이 할인: -%d원\n"
                    + "평일 할인: -%d원\n"
                    + "특별 할인: -%d원\n"
                    + "증정 이벤트: -%d원"),
    TOTAL_BENEFIT("<총혜택 금액>\n" + "-%d원"),
    DISCOUNT_PAYMENT("<할인 후 예상 결재 금액>\n" + "%d원"),
    EVENT_BADGE("<12월 이벤트 배지>\n" + "%s");

    private String message;

    OutputMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
