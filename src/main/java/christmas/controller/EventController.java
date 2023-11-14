package christmas.controller;

import christmas.model.ReservationInformation;
import christmas.view.InputView;

import java.util.HashMap;

public class EventController {

    private InputView inputView = new InputView();
    private ReservationInformation reservationInformation = new ReservationInformation();
    public void startBooking() {
        int reservationDate = inputView.inputDate(); // 날짜 입력
        HashMap<String, Integer> foodAndAmount = inputView.inputFoodAndAmount(); // 메뉴 입력
        reservationInformation.setReservationDate(reservationDate, foodAndAmount);
    }
}
