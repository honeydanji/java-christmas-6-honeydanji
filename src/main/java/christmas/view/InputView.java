package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.InputDateException;

import static christmas.utils.InputMessage.*;

public class InputView {
    private InputDateException inputDateException = new InputDateException();

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
}
