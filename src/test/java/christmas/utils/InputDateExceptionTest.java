package christmas.utils;

import org.junit.jupiter.api.Test;

import static christmas.utils.ExceptionMessage.NOT_NUMERIC;
import static christmas.utils.ExceptionMessage.OUT_OF_RANGE;
import static org.junit.jupiter.api.Assertions.*;

public class InputDateExceptionTest {

    private InputDateException inputDateException = new InputDateException();

    @Test
    void 날짜_예외_테스트_범위_벗어난_경우() {
        String date = "32";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputDateException.totalException(date));

        assertEquals(OUT_OF_RANGE, exception.getMessage());
    }

    @Test
    void 날짜_문자_입력한_경우_테스트() {
        String date = "a";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputDateException.totalException(date));

        assertEquals(NOT_NUMERIC, exception.getMessage());
    }
}
