package pairmatching.launcher.status;

import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class SelectFunctionStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        var command = inputView.readPairMatchingServiceCommand();

        if (command.isMatching()) {
            return new MatchingPairStatus();
        }
        if (command.isSearch()) {
            return new PairSearchStatus();
        }
        return null;
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
