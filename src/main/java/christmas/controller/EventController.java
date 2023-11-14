package christmas.controller;

import christmas.model.EventBenefit;
import christmas.model.ReservationInformation;
import christmas.model.TotalPaymentResult;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class EventController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ReservationInformation reservationInformation;
    private TotalPaymentResult totalPaymentResult;
    private EventBenefit eventBenefit;

    public EventController() {
        startBooking();
        beforeBenefits();
        createInstance();
        giftForPurchaseAmount();
        allEventBenefit();
    }

    private void startBooking() {
        reservationInformation = new ReservationInformation();
        int reservationDate = inputView.inputDate();
        HashMap<String, Integer> foodAndAmount = inputView.inputFoodAndAmount();
        reservationInformation.setReservationInformation(reservationDate, foodAndAmount);
        outputView.outputPreview(reservationInformation.getReservationDate());
    }

    private void beforeBenefits() {
        totalPaymentResult = new TotalPaymentResult(reservationInformation.getFoodAndAmount());
        outputView.outputMenu(reservationInformation.getFoodAndAmount());
        int totalPayment = totalPaymentResult.getTotalPayment();
        outputView.outputNotDiscountPayment(totalPayment);
    }

    private void createInstance() {
        eventBenefit = new EventBenefit(reservationInformation.getReservationDate(),
                                        reservationInformation.getFoodAndAmount(),
                                        totalPaymentResult.getTotalPayment());
    }

    private void giftForPurchaseAmount() {
        int gift = eventBenefit.gift();
        outputView.outputGift(gift);
    }

    private void allEventBenefit() {
        outputView.outputBenefitDetail();
        if (eventBenefit.getAllBenefitDetail().equals(List.of(0,0,0,0,0))) {
            outputView.outputNotThing();
            return;
        }
        outputView.outputChristmasDiscount(eventBenefit.getAllBenefitDetail().get(0));
        outputView.outputWeekdayDiscount(eventBenefit.getAllBenefitDetail().get(1));
        outputView.outputWeekendDiscount(eventBenefit.getAllBenefitDetail().get(2));
        outputView.outputSpecialDiscount(eventBenefit.getAllBenefitDetail().get(3));
        outputView.outputGiveawayDiscount(eventBenefit.getAllBenefitDetail().get(4));
    }
}
