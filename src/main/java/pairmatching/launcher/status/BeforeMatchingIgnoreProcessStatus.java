package pairmatching.launcher.status;

import pairmatching.exception.BeforeMatchedCrewException;
import pairmatching.launcher.context.PairmatchingContext;

public class BeforeMatchingIgnoreProcessStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        var outputView = pairmatchingContext.getPairmatchingView().getOutputView();
        pairmatchingContext.plusTryCount();
        try {
            outputView.printMatchingResultCrews(pairmatchingContext.rematchPair());
            return new SelectFeatureStatus();
        } catch (BeforeMatchedCrewException | IllegalStateException exception) {
            return this;
        }
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
