package pairmatching.launcher.context;

import pairmatching.domain.matching.MatchingDivision;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.PairmatchingView;

public class FakePairmatchingContext implements PairmatchingContext {

    @Override
    public PairmatchingView getPairmatchingView() {
        return new PairmatchingView(new InputView(), new OutputView());
    }

    @Override
    public void inputMatchingDivision(MatchingDivision matchingDivision) {

    }

    @Override
    public String matchPair() {
        return null;
    }

    @Override
    public String rematchPair() {
        return null;
    }

    @Override
    public String findMatchedCrewsByMatchingDivision() {
        return null;
    }

    @Override
    public void plusTryCount() {

    }

    @Override
    public void initializeRetryCount() {

    }

    @Override
    public void initializeMatchingResult() {

    }
}
