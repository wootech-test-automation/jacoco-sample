package pairmatching.launcher.status;

import pairmatching.launcher.context.PairmatchingContext;

public class QuitStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        return null;
    }

    @Override
    public boolean runnable() {
        return false;
    }
}
