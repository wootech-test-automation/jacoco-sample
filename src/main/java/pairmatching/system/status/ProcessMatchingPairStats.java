package pairmatching.system.status;

import pairmatching.system.PairmatchingContext;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class ProcessMatchingPairStats implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext, InputView inputView,
                                   OutputView outputView) {
        try {
            outputView.printMatchingResult(pairmatchingContext.matchPair());
        } catch (IllegalStateException exception) {
            return new RetryProcessMatchingPairStatus();
        }
        return new SelectFeaturesStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
