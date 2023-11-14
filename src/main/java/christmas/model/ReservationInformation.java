package christmas.model;

import java.util.HashMap;

public class ReservationInformation {
    private int reservationDate;
    private HashMap<String, Integer> foodAndAmount;

    public void setReservationDate(int reservationDate, HashMap<String, Integer> foodAndAmount) {
        this.reservationDate = reservationDate;
        this.foodAndAmount = foodAndAmount;
    }
}
