package pairmatching.view;

public class OutputView extends IoPrinter {
    private static final String ERROR_FORMAT = "[ERROR] %s";

    public void printMatchingResult(final String matchPair) {
        this.println(matchPair);
    }

    public void printError(Exception exception) {
        this.println(String.format(ERROR_FORMAT, exception.getMessage()));
    }

    public void printInitializeMessage() {
        this.println("초기화 되었습니다.");
    }
}
