package christmas.view;

import static christmas.utils.OutputMessage.PREVIEW;

public class OutputView {

    public void outputPreview(int reservationDate) {
        System.out.println(String.format(PREVIEW.getMessage(), reservationDate));
    }
}
