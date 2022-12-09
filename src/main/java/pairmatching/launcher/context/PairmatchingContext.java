package pairmatching.launcher.context;

import pairmatching.domain.matching.MatchingDivision;
import pairmatching.view.PairmatchingView;

public interface PairmatchingContext {


    PairmatchingView getPairmatchingView();

    void inputMatchingDivision(MatchingDivision matchingDivision);

    String matchPair();

    String rematchPair();

    String findMatchedCrewsByMatchingDivision();

    void plusTryCount();

    void initializeRetryCount();

    void initializeMatchingResult();
}
