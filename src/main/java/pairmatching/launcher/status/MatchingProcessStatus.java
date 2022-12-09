package pairmatching.launcher.status;

import pairmatching.exception.BeforeMatchedCrewException;
import pairmatching.exception.DuplicatedMatchingDivisionException;
import pairmatching.launcher.context.PairmatchingContext;
import pairmatching.view.OutputView;

public class MatchingProcessStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(PairmatchingContext pairmatchingContext) {
        var pairmatchingView = pairmatchingContext.getPairmatchingView();
        var outputView = pairmatchingView.getOutputView();

        pairmatchingContext.plusTryCount();
        return this.getNextStatus(pairmatchingContext, outputView);
    }

    private PairmatchingStatus getNextStatus(PairmatchingContext pairmatchingContext, OutputView outputView) {
        try {
            outputView.printMatchingResultCrews(pairmatchingContext.matchPair());
            return new SelectFeatureStatus();
        } catch (DuplicatedMatchingDivisionException duplicatedMatchingDivisionException) {
            return new AskRematchingStatus();
        } catch (BeforeMatchedCrewException | IllegalStateException exception) {
            return this;
        }
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
