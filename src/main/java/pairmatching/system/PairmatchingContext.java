package pairmatching.system;

import pairmatching.matching.MatchingDivision;

public interface PairmatchingContext {

    void requestMatching(MatchingDivision matchingDivision);

    String matchPair();

    void retryMatching();
}
