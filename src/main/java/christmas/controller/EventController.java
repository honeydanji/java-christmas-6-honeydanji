package christmas.controller;

import christmas.model.EventBenefit;
import christmas.model.ReservationInformation;
import christmas.model.TotalPaymentResult;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;

public class EventController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ReservationInformation reservationInformation = new ReservationInformation();
    private TotalPaymentResult totalPaymentResult = new TotalPaymentResult(reservationInformation.getFoodAndAmount());
    private EventBenefit eventBenefit = new EventBenefit(reservationInformation.getReservationDate(),
                                                            reservationInformation.getFoodAndAmount(),
                                                            totalPaymentResult.getTotalPayment());
    public EventController() {
        startBooking();
        beforeBenefits();
        giftForPurchaseAmount();
    }

    private void startBooking() {
        int reservationDate = inputView.inputDate();
        HashMap<String, Integer> foodAndAmount = inputView.inputFoodAndAmount();
        reservationInformation.setReservationInformation(reservationDate, foodAndAmount);
        outputView.outputPreview(reservationInformation.getReservationDate());
    }

    private void beforeBenefits() {
        outputView.outputMenu(reservationInformation.getFoodAndAmount());
        int totalPayment = totalPaymentResult.getTotalPayment();
        outputView.outputNotDiscountPayment(totalPayment);
    }

    private void giftForPurchaseAmount() {
        boolean gift = eventBenefit.gift();
        outputView.outputGift(gift);
    }
}
