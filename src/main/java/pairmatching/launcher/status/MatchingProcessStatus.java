package pairmatching.launcher.status;

import pairmatching.launcher.context.PairmatchingContext;

public class MatchingProcessStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        pairmatchingContext.matchPair();
        return null;
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
