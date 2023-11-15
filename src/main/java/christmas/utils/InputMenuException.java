package christmas.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

import static christmas.utils.ExceptionMessage.*;

public class InputMenuException {

    public void preConversionException(String foodAndAmount) {
        mismatchedMenu(foodAndAmount);
        repeatedMenu(foodAndAmount);
    }

    public void postConversionException(HashMap<String, Integer> foodAndAmount) {
        notOnlyDrink(foodAndAmount);
        nonExistentMenu(foodAndAmount);
        invalidMenuCount(foodAndAmount);
    }

    private void mismatchedMenu(String foodAndAmount) {
        // 정규 표현식 패턴
        String regex = "^(\\p{L}+-\\d+)(,\\s*\\p{L}+-\\d+)*$";

        if (!Pattern.matches(regex, foodAndAmount)) {
            throw new IllegalArgumentException(MISMATCHED_MENU);
        }
    }

    private void repeatedMenu(String foodAndAmount) {
        String[] splitText = foodAndAmount.split("[\\s,\\d-]+");
        HashSet<String> duplicatedCheck = new HashSet<>();
        for(String s : splitText) {
            duplicatedCheck.add(s);
        }
        if(splitText.length != duplicatedCheck.size()) {
            throw new IllegalArgumentException(REPEATED_MENU);
        }
    }

    private void nonExistentMenu(HashMap<String, Integer> foodAndAmount) {
        List<String> foodCheck = new ArrayList<>(foodDto());

        for(String s : foodAndAmount.keySet()) {
            if (!foodCheck.contains(s)) {
                throw new IllegalArgumentException(NON_EXISTENT_MENU);
            }
        }
    }

    private void notOnlyDrink(HashMap<String, Integer> foodAndAmount) {
        List<String> foodCheck = new ArrayList<>(notDrinkOnlyFoodDto());

        for(String s : foodAndAmount.keySet()) {
            if (foodCheck.contains(s)) {
                return;
            }
        }
        throw new IllegalArgumentException(NOT_ONLY_DRINK);
    }

    private void invalidMenuCount(HashMap<String, Integer> foodAndAmount) {
        int total = 0;
        for(String food : foodAndAmount.keySet()) {
            total += foodAndAmount.get(food);
        }
        if(total > 20 || total < 1) {
            throw new IllegalArgumentException(INVALID_MENU_COUNT);
        }
    }

    private List<String> foodDto() {
        return List.of("양송이스프","타파스","시저샐러드",
                        "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타",
                        "초코케이크","아이스크림",
                        "제로콜라","레드와인","샴페인");
    }

    private List<String> notDrinkOnlyFoodDto() {
        return List.of("양송이스프","타파스","시저샐러드",
                "티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타",
                "초코케이크","아이스크림");
    }
}
