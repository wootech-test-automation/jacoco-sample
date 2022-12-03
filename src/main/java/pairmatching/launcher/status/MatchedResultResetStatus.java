package pairmatching.launcher.status;

import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchedResultResetStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        pairmatchingContext.resetMatchedPair();
        return new SelectFunctionStatus();
    }

    @Override
    public boolean runnable() {
        return false;
    }
}
