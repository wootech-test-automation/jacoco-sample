package pairmatching.launcher.status;

import pairmatching.exception.MatchingDivisionDidNotExists;
import pairmatching.launcher.context.PairmatchingContext;

public class FindMatchingResultStatus implements PairmatchingStatus {

    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        var pairmatchingView = pairmatchingContext.getPairmatchingView();
        var outputView = pairmatchingView.getOutputView();

        try {
            outputView.printMatchingResultCrews(pairmatchingContext.findMatchedCrewsByMatchingDivision());
        } catch (MatchingDivisionDidNotExists matchingDivisionDidNotExists) {
            throw new IllegalArgumentException("매칭 이력이 없습니다.");
        }

        return new SelectFeatureStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
