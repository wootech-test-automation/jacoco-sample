package pairmatching.view;

import java.util.Set;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.Pair;

public class OutputView extends View {

    private static final String RESULT_MATCHING = "페어 매칭 결과입니다.";
    private static final String INITIALIZED = "초기화 되었습니다.";


    public void showResult(Set<Pair> pairs) {
        print(RESULT_MATCHING);
        for (Pair pair : pairs) {
            print(makePairFormat(pair));
        }
        printEmptyLine();
    }

    public void reset() {
        print(INITIALIZED);
        printEmptyLine();
    }

    @Override
    public void printError(String message) {
        super.printError(message);
    }

    private String makePairFormat(Pair pair) {
        Crew firstCrew = pair.getFirst();
        Crew secondCrew = pair.getSecond();
        Crew thirdCrew = pair.getThird();
        if (thirdCrew == null) {
            return firstCrew.getName() + " : " + secondCrew.getName();
        }
        return firstCrew.getName() + " : " + secondCrew.getName() + " : " + thirdCrew.getName();
    }
}
