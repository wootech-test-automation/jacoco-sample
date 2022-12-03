package pairmatching.launcher.status;

import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class InitStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        return new SelectFunctionStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
