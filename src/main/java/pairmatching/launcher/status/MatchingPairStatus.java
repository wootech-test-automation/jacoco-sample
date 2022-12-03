package pairmatching.launcher.status;

import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingPairStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        if (pairmatchingContext.matchCount() > 3) {
            throw new IllegalStateException("페어를 매칭할  수 없습니다.");
        }

        pairmatchingContext.plusMatchCount();
        
        return process(pairmatchingContext, inputView, outputView);

    }

    private PairmatchingStatus process(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        try {
            outputView.printMatchingResult(pairmatchingContext.matchPair());
            return new SelectFunctionStatus();
        } catch (IllegalArgumentException stateException) {
            return requestReEnter(inputView);
        } catch (IllegalStateException exception) {
            return new MatchingPairStatus();
        }
    }

    private PairmatchingStatus requestReEnter(InputView inputView) {
        if (inputView.readReEnter().isRetry()) {
            return this;
        }
        return new SelectFunctionStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
