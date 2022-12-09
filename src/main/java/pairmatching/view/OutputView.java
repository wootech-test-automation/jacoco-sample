package pairmatching.view;

public class OutputView extends IoPrinter {

    public void printMatchingResultCrews(String matchedCrewNames) {
        this.println("페어 매칭 결과입니다.");
        this.println(matchedCrewNames);
    }
}
