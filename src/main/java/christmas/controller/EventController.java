package christmas.controller;

import christmas.model.BadgeByBenefit;
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
    private BadgeByBenefit badgeByBenefit;

    public EventController() {
        startBooking();             // 예약시작
        beforeBenefits();           // 혜택 적용전 금액
        createInstance();           // 함수명 변경
        giftForPurchaseAmount();    // 구매금액에 따른 증정
        allEventBenefit();          // 총혜택 내역
        totalBenefit();             // 총혜택 금액
        totalAmountAfterBenefit();  // 혜택 적용된 금액
        badgeByBenefit();           // 혜택 금액에 따른 배지
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
    private void totalBenefit() {
        int totalBenefit = eventBenefit.totalBenefit();
        outputView.outputTotalBenefit(totalBenefit);
    }

    private void totalAmountAfterBenefit() {
        int totalBenefit = eventBenefit.totalBenefit();
        int totalAmountBeforeBenefits = totalPaymentResult.getTotalPayment();
        int totalAmountAfterBenefits = totalPaymentResult.estimatePaymentAfterDiscount(totalAmountBeforeBenefits, totalBenefit);
        outputView.outputDiscountPayment(totalAmountAfterBenefits);
    }

    private void badgeByBenefit() {
        badgeByBenefit = new BadgeByBenefit(eventBenefit.totalBenefit());
        String badge = badgeByBenefit.badge();
        outputView.outputBadgeOfBenefit(badge);
    }
}

