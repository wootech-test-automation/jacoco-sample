package pairmatching.system.status;

import pairmatching.system.PairmatchingContext;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class SelectPairMatching implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext, InputView inputView,
                                   OutputView outputView) {
        pairmatchingContext.requestMatching(inputView.readMatchingDivision());
        outputView.printMatchingResult(pairmatchingContext.selectMatching());
        return new SelectFeaturesStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
