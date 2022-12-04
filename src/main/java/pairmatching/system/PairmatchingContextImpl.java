package pairmatching.system;

import pairmatching.domain.count.RepeatMatchingCount;
import pairmatching.domain.matching.MatchingDivision;
import pairmatching.domain.matching.MatchingResult;

public class PairmatchingContextImpl implements PairmatchingContext {

    private MatchingResult matchingResult;
    private MatchingDivision matchingDivision;
    private RepeatMatchingCount repeatMatchingCount;

    public PairmatchingContextImpl() {
        this.matchingResult = new MatchingResult();
    }

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
    public void initializeMatchingCount() {
        this.repeatMatchingCount = RepeatMatchingCount.initializeRepeatMatchingCount();
    }

    @Override
    public String selectMatching() {
        return matchingResult.findMatchingPair(this.matchingDivision);
    }

    @Override
    public void initializeMatchingResult() {
        this.matchingResult = new MatchingResult();
    }
}
