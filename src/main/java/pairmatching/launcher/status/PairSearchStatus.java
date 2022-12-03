package pairmatching.launcher.status;

import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairSearchStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        var result = pairmatchingContext.searchPair(inputView.readPairMatchingSelector());
        outputView.printMatchingResult(result);
        return null;
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
