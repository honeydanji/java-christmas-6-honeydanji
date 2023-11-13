package christmas.controller;

import christmas.view.InputView;

public class EventController {

    private InputView inputView = new InputView();

    // 이벤트 시작
    public void startBooking() {
        inputView.inputDate();
    }
}
