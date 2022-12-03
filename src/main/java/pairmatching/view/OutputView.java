package pairmatching.view;

public class OutputView extends IoPrinter {
    public void printMatchingResult(String matchPair) {
        this.println(matchPair);
    }

    public void printReset() {
        this.println("초기화 되었습니다.");
    }

    public void printError(String message) {
        this.println("[ERROR]" + message);
    }
}
