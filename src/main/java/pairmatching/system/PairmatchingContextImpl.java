package pairmatching.system;

import pairmatching.domain.count.RepeatMatchingCount;
import pairmatching.matching.MatchingDivision;
import pairmatching.matching.MatchingResult;

public class PairmatchingContextImpl implements PairmatchingContext {

    private final MatchingResult matchingResult = new MatchingResult();
    private MatchingDivision matchingDivision;
    private RepeatMatchingCount repeatMatchingCount = RepeatMatchingCount.initializeRepeatMatchingCount();

    @Override
    public void requestMatching(MatchingDivision matchingDivision) {
        this.matchingDivision = matchingDivision;

    }

    @Override
    public String matchPair() {
        this.matchingResult.matchPair(matchingDivision, matchingDivision.getShuffledCrew());
        return this.matchingResult.findMatchingPair(matchingDivision);
    }

    @Override
    public void retryMatching() {
        repeatMatchingCount = repeatMatchingCount.plusCount();
    }
}
