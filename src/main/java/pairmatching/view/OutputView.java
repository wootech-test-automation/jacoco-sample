package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import pairmatching.domain.Pair;

public class OutputView {
    public void printMessage(final String message) {
        System.out.println(message);
        System.out.println();
    }

    public void printPairMatchingResult(final List<Pair> pairMatch) {
        System.out.println("페어 매칭 결과입니다.");
        System.out.println(createPairResultMessage(pairMatch));
    }

    private String createPairResultMessage(final List<Pair> pairMatch) {
        StringBuilder message = new StringBuilder();
        Arrays.stream(pairMatch.toString()
                .replaceAll("(?:\\[|null|\\]|)", "")
                .split(","))
                .forEach(match -> message.append(match.trim()).append("\n"));
        return message.toString();
    }

    public void printResetMessage() {
        System.out.println("초기화 되었습니다.");
    }
}
