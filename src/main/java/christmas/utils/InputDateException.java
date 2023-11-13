package christmas.utils;

public class InputDateException {

    public void totalException(String date) {
        notNumeric(date);
        OutOfRange(date);
    }

    // 숫자 문자열 변환
    private void notNumeric(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    // 숫자범위
    private void OutOfRange(String date) {
        int dateChange = Integer.parseInt(date);
        if(dateChange <= 0 || dateChange > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
