package pairmatching.launcher.status;

import pairmatching.launcher.code.CommandToStatusConvertor;
import pairmatching.launcher.context.PairmatchingContext;

public class SelectFeatureStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        var pairmatchingView = pairmatchingContext.getPairmatchingView();
        var featureCommand = pairmatchingView.getInputView().readFeatureCommand();

        return CommandToStatusConvertor.getNextStatus(featureCommand);
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
