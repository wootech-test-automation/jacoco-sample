package pairmatching.matching;

import java.util.HashMap;
import java.util.Map;

public class MatchingResult {
    private final Map<MatchingDivision, MatchedCrews> matchingResult = new HashMap<>();


    public void matchPair(MatchingDivision matchingDivision) {
        this.matchingResult.put(matchingDivision, new MatchedCrews(matchingDivision.getShuffledCrew()));
    }

}
