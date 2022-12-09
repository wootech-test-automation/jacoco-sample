package pairmatching.launcher.status;

import pairmatching.launcher.context.PairmatchingContext;

public interface PairmatchingStatus {
    PairmatchingStatus next(PairmatchingContext pairmatchingContext);

    boolean runnable();
}
