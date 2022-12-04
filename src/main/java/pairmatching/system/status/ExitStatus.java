package pairmatching.system.status;

import pairmatching.system.PairmatchingContext;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ExitStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext, InputView inputView,
                                   OutputView outputView) {
        return null;
    }

    @Override
    public boolean runnable() {
        return false;
    }
}
