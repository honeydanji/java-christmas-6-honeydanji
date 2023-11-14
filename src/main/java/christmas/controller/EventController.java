package christmas.controller;

import christmas.model.ReservationInformation;
import christmas.view.InputView;

import java.util.HashMap;

public class EventController {

    private InputView inputView = new InputView();
    private ReservationInformation reservationInformation = new ReservationInformation();
    public void startBooking() {
        int reservationDate = inputView.inputDate();
        HashMap<String, Integer> foodAndAmount = inputView.inputFoodAndAmount();
        reservationInformation.setReservationInformation(reservationDate, foodAndAmount);
    }
}
