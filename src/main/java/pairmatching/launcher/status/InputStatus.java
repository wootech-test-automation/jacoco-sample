package pairmatching.launcher.status;

import pairmatching.launcher.context.PairmatchingContext;

public class InputStatus implements PairmatchingStatus {

    private final PairmatchingStatus nextStatus;

    public InputStatus(PairmatchingStatus nextStatus) {
        this.nextStatus = nextStatus;
    }

    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        var pairmatchingView = pairmatchingContext.getPairmatchingView();
        var inputView = pairmatchingView.getInputView();
        var outputView = pairmatchingView.getOutputView();

        pairmatchingContext.initializeRetryCount();

        outputView.printMatchingMenu();
        pairmatchingContext.inputMatchingDivision(inputView.readPairmatchingDivision());

        return nextStatus;
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
