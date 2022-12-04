package pairmatching.system.status;

import pairmatching.domain.code.FeaturesCommandCode;
import pairmatching.system.PairmatchingContext;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class SelectFeaturesStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext, InputView inputView,
                                   OutputView outputView) {

        pairmatchingContext.initializeMatchingCount();

        return processFeatureCommand(inputView.readFeatureCommand());
    }

    private PairmatchingStatus processFeatureCommand(FeaturesCommandCode featureCommand) {
        if (featureCommand.isMatching()) {
            return new MatchingPairStatus();
        }
        if (featureCommand.isSelecting()) {
            return new SelectPairMatching();
        }
        if (featureCommand.isResting()) {
            return new InitializeResultStatus();
        }
        return new ExitStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
