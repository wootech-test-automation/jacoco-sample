package pairmatching.launcher.context;

import pairmatching.domain.matching.MatchingDivision;
import pairmatching.view.PairmatchingView;

public class FakePairmatchingContext implements PairmatchingContext {

    @Override
    public PairmatchingView getPairmatchingView() {
        return null;
    }

    @Override
    public void inputMatchingDivision(MatchingDivision matchingDivision) {

    }
}
