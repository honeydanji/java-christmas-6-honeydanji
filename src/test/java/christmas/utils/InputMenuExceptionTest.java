package christmas.utils;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static christmas.utils.ExceptionMessage.*;
import static org.junit.jupiter.api.Assertions.*;

public class InputMenuExceptionTest {

    private InputMenuException inputMenuException = new InputMenuException();

    @Test
    void 형식에_맞지_않는_메뉴_입력_테스트() {
        String test = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라--1";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                        inputMenuException.preConversionException(test));

        assertEquals(MISMATCHED_MENU, exception.getMessage());
    }

    @Test
    void 형식에_맞게_메뉴_여러개_입력_테스트() {
        String test = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        assertDoesNotThrow(() -> inputMenuException.preConversionException(test));
    }

    @Test
    void 형식에_맞게_메뉴_1개_입력_테스트() {
        String test = "티본스테이크-1";
        assertDoesNotThrow(() -> inputMenuException.preConversionException(test));
    }

    @Test
    void 메뉴_반복_입력_테스트() {
        String test = "티본스테이크-1,티본스테이크-1,초코케이크-2,제로콜라-1";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputMenuException.preConversionException(test));

        assertEquals(REPEATED_MENU, exception.getMessage());
    }

    @Test
    void 존재하지_않는_메뉴_입력_테스트() {
        HashMap<String, Integer> test = new HashMap<>();
        test.put("티본스테이크",1);
        test.put("바비큐립",1);
        test.put("초코케이크",2);
        test.put("제로콜라",1);
        test.put("제육볶음",1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputMenuException.postConversionException(test));

        assertEquals(NON_EXISTENT_MENU, exception.getMessage());
    }

    @Test
    void 메뉴_입력_1개_미만인_경우_테스트() {
        HashMap<String, Integer> test = new HashMap<>();
        test.put("티본스테이크",0);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputMenuException.postConversionException(test));

        assertEquals(INVALID_MENU_COUNT, exception.getMessage());
    }

    @Test
    void 메뉴_입력_20개_초과인_경우_테스트() {
        HashMap<String, Integer> test = new HashMap<>();
        test.put("티본스테이크",2);
        test.put("샴페인",12);
        test.put("레드와인",1);
        test.put("아이스크림",100);
        test.put("초코케이크",15);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                inputMenuException.postConversionException(test));

        assertEquals(INVALID_MENU_COUNT, exception.getMessage());
    }
}
