package christmas.utils;

import static christmas.utils.ExceptionMessage.NOT_NUMERIC;
import static christmas.utils.ExceptionMessage.OUT_OF_RANGE;

public class InputDateException {

    public void totalException(String date) {
        notNumeric(date);
        OutOfRange(date);
    }

    private void notNumeric(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }

    private void OutOfRange(String date) {
        int dateChange = Integer.parseInt(date);
        if(dateChange <= 0 || dateChange > 31) {
            throw new IllegalArgumentException(OUT_OF_RANGE);
        }
    }
}
