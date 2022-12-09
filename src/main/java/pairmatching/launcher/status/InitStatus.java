package pairmatching.launcher.status;

import pairmatching.launcher.context.PairmatchingContext;

public class InitStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        return new SelectFeatureStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
