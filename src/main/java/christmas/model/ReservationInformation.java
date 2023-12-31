package christmas.model;

import java.util.HashMap;

public class ReservationInformation {
    private int reservationDate;
    private HashMap<String, Integer> foodAndAmount;

    public void setReservationInformation(int reservationDate, HashMap<String, Integer> foodAndAmount) {
        this.reservationDate = reservationDate;
        this.foodAndAmount = foodAndAmount;
    }

    public int getReservationDate() {
        return reservationDate;
    }

    public HashMap<String,Integer> getFoodAndAmount() {
        return foodAndAmount;
    }
}
