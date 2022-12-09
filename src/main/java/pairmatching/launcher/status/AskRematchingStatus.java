package pairmatching.launcher.status;

import pairmatching.launcher.context.PairmatchingContext;

public class AskRematchingStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        var pairMatchingView = pairmatchingContext.getPairmatchingView();
        var inputView = pairMatchingView.getInputView();

        var rematchingCommand = inputView.readReMatchingCommand();
        if (rematchingCommand.isRematching()) {
            return new BeforeMatchingIgnoreProcessStatus();
        }
        
        pairmatchingContext.inputMatchingDivision(inputView.readPairmatchingDivision());
        return new MatchingProcessStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
