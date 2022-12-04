package pairmatching.system.status;

import pairmatching.system.PairmatchingContext;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class RetryProcessMatchingPairStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext, InputView inputView,
                                   OutputView outputView) {

        var command = inputView.readRetryCommand();

        if (command.isRetry()) {
            pairmatchingContext.plusRetryCount();
            return new MatchingPairStatus();
        }

        return new ExitStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
