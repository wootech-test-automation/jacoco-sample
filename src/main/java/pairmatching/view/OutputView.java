package pairmatching.view;

import java.util.List;
import pairmatching.domain.Pair;

public class OutputView {

    public void printPairMatchingResult(List<Pair> pairs) {
        System.out.println("페어 매칭 결과입니다.");
        pairs.forEach(this::printPairNames);
    }

    private void printPairNames(Pair pair) {
        List<String> names = pair.getNames();
        System.out.println(String.join(" : ",names));
    }

}
