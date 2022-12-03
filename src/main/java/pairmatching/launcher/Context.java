package pairmatching.launcher;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.crew.MatchedCrew;
import pairmatching.domain.crew.MatchingResult;
import pairmatching.domain.info.PairMatchingSelector;

public class Context {
    private final MatchingResult matchingResult = new MatchingResult();

    public String matchPair(PairMatchingSelector pairMatchingSelector) {
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
}
