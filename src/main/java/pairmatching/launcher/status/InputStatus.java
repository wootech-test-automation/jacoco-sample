package pairmatching.launcher.status;

import pairmatching.launcher.context.PairmatchingContext;

public class InputStatus implements PairmatchingStatus {

    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        var pairmatchingView = pairmatchingContext.getPairmatchingView();
        var matchingDivision = pairmatchingView.getInputView().readPairmatchingDivision();

        pairmatchingContext.inputMatchingDivision(matchingDivision);

        return new MatchingProcessStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
