package pairmatching.system.status;

import pairmatching.system.PairmatchingContext;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingPairStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext, InputView inputView,
                                   OutputView outputView) {

        var matchingDivision = inputView.readMatchingDivision();
        
        pairmatchingContext.requestMatching(matchingDivision);

        return new ProcessMatchingPairStats();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
