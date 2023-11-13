package christmas.controller;

import christmas.view.InputView;

public class EventController {

    private InputView inputView = new InputView();

    // 이벤트 시작
    public void startBooking() {
        inputView.inputDate(); // 날짜 입력
        inputView.inputFoodAndAmount(); // 메뉴 입력
    }
}
