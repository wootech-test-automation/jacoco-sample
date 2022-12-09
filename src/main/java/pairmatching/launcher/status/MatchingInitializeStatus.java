package pairmatching.launcher.code;

import pairmatching.launcher.context.PairmatchingContext;
import pairmatching.launcher.status.PairmatchingStatus;
import pairmatching.launcher.status.SelectFeatureStatus;

public class MatchingInitializeStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        var pairmatchingView = pairmatchingContext.getPairmatchingView();

        pairmatchingContext.initializeMatchingResult();
        pairmatchingView.getOutputView().printInitializeMessage();

        return new SelectFeatureStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
