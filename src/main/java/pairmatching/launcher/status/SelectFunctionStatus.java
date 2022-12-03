package pairmatching.launcher.status;

import pairmatching.domain.code.FunctionCommand;
import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class SelectFunctionStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        pairmatchingContext.resetMatchCount();
        var command = inputView.readPairMatchingServiceCommand();

        return verifyCommand(command);
    }

    private PairmatchingStatus verifyCommand(FunctionCommand command) {
        if (command.isMatching()) {
            return new SetMatchingPairStatus();
        }
        if (command.isSearch()) {
            return new PairSearchStatus();
        }
        if (command.isReset()) {
            return new MatchedResultResetStatus();
        }
        return new QuitStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
