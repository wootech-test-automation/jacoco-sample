package pairmatching.system;

import pairmatching.domain.matching.MatchingDivision;

public interface PairmatchingContext {

    void requestMatching(MatchingDivision matchingDivision);

    String matchPair();


    void initializeMatchingCount();

    String selectMatching();

    void initializeMatchingResult();
}
