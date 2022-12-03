package pairmatching.launcher.status;

import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class SetMatchingPairStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        pairmatchingContext.generate(inputView.readPairMatchingSelector());
        return new MatchingPairStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
