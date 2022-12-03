package pairmatching.launcher;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.crew.MatchedCrew;
import pairmatching.domain.crew.MatchingResult;
import pairmatching.domain.info.PairMatchingSelector;

public class Context {
    int count = 1;
    private MatchingResult matchingResult = new MatchingResult();

    public String matchPair(PairMatchingSelector pairMatchingSelector) {
        if (matchingResult.findBeforeMatchingResult(pairMatchingSelector)) {
            throw new IllegalStateException("매칭 정보가 이미 존재합니다");
        }
        return matchedCrewToResult(matchingResult.addMatching(pairMatchingSelector));
    }

    public String searchPair(PairMatchingSelector pairMatchingSelector) {
        return matchedCrewToResult(matchingResult.searchMatching(pairMatchingSelector));
    }

    private String matchedCrewToResult(List<MatchedCrew> matchedCrew) {
        return matchedCrew.stream()
                .map(MatchedCrew::result)
                .collect(Collectors.joining("\n"));
    }

    public void resetMatchedPair() {
        this.matchingResult = new MatchingResult();
    }

    public int plusMatchCount() {
        return count++;
    }

    public void resetMatchCount() {
        this.count = 1;
    }
}
