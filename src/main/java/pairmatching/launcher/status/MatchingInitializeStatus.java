package pairmatching.launcher.status;

import pairmatching.launcher.context.PairmatchingContext;

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
