package pairmatching.system.status;

import pairmatching.system.PairmatchingContext;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class InitializeResultStatus implements PairmatchingStatus {

    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext, InputView inputView,
                                   OutputView outputView) {
        outputView.printInitializeMessage();
        pairmatchingContext.initializeMatchingResult();
        return new SelectFeaturesStatus();
    }

    @Override
    public boolean runnable() {
        return false;
    }
}
