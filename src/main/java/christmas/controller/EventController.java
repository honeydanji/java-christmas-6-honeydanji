package christmas.controller;

import christmas.model.ReservationInformation;
import christmas.model.TotalPaymentResult;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;

public class EventController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ReservationInformation reservationInformation = new ReservationInformation();

    public EventController() {
        startBooking();
        beforeBenefits();
    }

    private void startBooking() {
        int reservationDate = inputView.inputDate();
        HashMap<String, Integer> foodAndAmount = inputView.inputFoodAndAmount();
        reservationInformation.setReservationInformation(reservationDate, foodAndAmount);
        outputView.outputPreview(reservationInformation.getReservationDate());
    }

    private void beforeBenefits() {
        TotalPaymentResult totalPaymentResult = new TotalPaymentResult();

        outputView.outputMenu(reservationInformation.getFoodAndAmount());
        int total = totalPaymentResult.getTotalPayment(reservationInformation.getFoodAndAmount());
        outputView.outputNotDiscountPayment(total);
    }
}
