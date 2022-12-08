package pairmatching.view;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class InputView extends IoPrinter {


    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException("더 이상 입력할 수 없습니다.");
        }
    }

    private String readLineBeforeNewLine() {
        this.println();
        return this.readLine();
    }
}
