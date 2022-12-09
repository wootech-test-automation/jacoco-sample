package pairmatching.view;

import pairmatching.domain.code.Course;
import pairmatching.domain.code.Level;

public class OutputView extends IoPrinter {

    public void printMatchingResultCrews(String matchedCrewNames) {
        this.println("페어 매칭 결과입니다.");
        this.println(matchedCrewNames);
    }

    public void printInitializeMessage() {
        this.println("초기화 되었습니다. ");
    }

    public void printError(final Object message) {
        this.println("[ERROR]" + message);
    }

    public void printMatchingMenu() {
        this.println(DIVISION_HASH);
        this.println(String.format("과정 : %s", Course.messages()));
        this.println(Level.messages());
        this.println(DIVISION_HASH);
    }
}
