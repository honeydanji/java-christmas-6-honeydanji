package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputDateException;
import christmas.utils.InputMenuException;

import java.util.HashMap;

import static christmas.utils.InputMessage.*;

public class InputView {
    private InputDateException inputDateException = new InputDateException();
    private InputMenuException inputMenuException = new InputMenuException();

    // 날짜 입력 받기
    public int inputDate() {
        System.out.println(EVENT_START.getMessage());   // 이벤트 시작 안내 문구
        System.out.println(INPUT_DATE.getMessage());    // 날짜 입력

        while(true) {
            try {
                String date = Console.readLine();
                inputDateException.totalException(date);
                int reservationDate = Integer.parseInt(date);
                return reservationDate;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public HashMap<String, Integer> inputFoodAndAmount() {
        System.out.println(INPUT_MENU.getMessage());
        while (true) {
            try {
                String input = Console.readLine();
                inputMenuException.preConversionException(input); // 타입변환 전 예외 검사 2개
                HashMap<String, Integer> foodAndAmount = typeChange(input);
                inputMenuException.postConversionException(foodAndAmount); // 타입변환 후 예외 검사 2개
                return foodAndAmount;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private HashMap<String, Integer> typeChange(String input) {
        HashMap<String, Integer> foodAndAmount = new HashMap<>();

        String[] oneProcess = input.split(",");
        for(String a : oneProcess) {
            String[] twoProcess = a.split("-");
            foodAndAmount.put(twoProcess[0],Integer.parseInt(twoProcess[1]));
        }
        return foodAndAmount;
    }
}
