package christmas.model;

public enum CalculateTotalPayment {
    // 에피타이저
    양송이스프(6000) { int price(int amount) { return amount * FOOD_PRICE; } },
    타파스(5500) { int price(int amount) { return amount * FOOD_PRICE; } },
    시저샐러드(8000) { int price(int amount) { return amount * FOOD_PRICE; } },
    // 메인
    티본스테이크(55000) { int price(int amount) { return amount * FOOD_PRICE; } },
    바비큐립(54000) { int price(int amount) { return amount * FOOD_PRICE; } },
    해산물파스타(35000) { int price(int amount) { return amount * FOOD_PRICE; } },
    크리스마스파스타(25000) { int price(int amount) { return amount * FOOD_PRICE; } },
    // 디저트
    초코케이크(15000) { int price(int amount) { return amount * FOOD_PRICE; } },
    아이스크림(5000) { int price(int amount) { return amount * FOOD_PRICE; } },
    // 음료
    제로콜라(3000) { int price(int amount) { return amount * FOOD_PRICE; } },
    레드와인(60000) { int price(int amount) { return amount * FOOD_PRICE; } },
    샴페인(25000) { int price(int amount) { return amount * FOOD_PRICE; } };

    protected final int FOOD_PRICE; // 해당 클래스 및 하위 클래스에서 만 접근 가능
    CalculateTotalPayment(int foodPrice) {
        this.FOOD_PRICE = foodPrice;
    }

    public int getFoodPrice() {
        return FOOD_PRICE;
    }

    abstract int price(int amount); // 상속을 받은 하위클래스에서 구현해서 사용 가능.
}
