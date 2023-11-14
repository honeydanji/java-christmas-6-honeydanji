package christmas.model;

import java.util.List;

public class DecemberEventData {

    public List<Integer> christmasPeriod() {
        return List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25);
    }

    public List<Integer> weekday() {
        return List.of(3,4,5,6,7,10,11,12,13,14,17,18,19,20,21,24,25,26,27,28,31);
    }
    public List<Integer> weekend() {
        return List.of(1,2,8,9,15,16,22,23,29,30);
    }

    public List<Integer> specialDay() {
        return List.of(3,10,17,24,25,31);
    }

    public List<String> desert() {
        return List.of("초코케이크", "아이스크림");
    }

    public List<String> mainDish() {
        return List.of("티본스테이크","바비큐립","해산물파스타","크리스마스파스타");
    }
}
