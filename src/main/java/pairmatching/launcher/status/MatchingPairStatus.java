package pairmatching.launcher.status;

import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingPairStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        var pairMatchingSelector = inputView.readPairMatchingSelector();
        try {
            outputView.printMatchingResult(pairmatchingContext.matchPair(pairMatchingSelector));
        } catch (IllegalArgumentException stateException) {
            if (inputView.readReEnter().isRetry()) {
                return this;
            }
        } catch (IllegalStateException stateException) {
            return new MatchingFailStatus();
        }
        return new SelectFunctionStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
