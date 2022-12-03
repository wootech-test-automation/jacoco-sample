package pairmatching.launcher.status;

import pairmatching.launcher.Context;
import pairmatching.launcher.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingFailStatus implements PairmatchingStatus {
    @Override
    public PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView) {
        int count = pairmatchingContext.plusMatchCount();
        if (count > 2) {
            throw new IllegalStateException("더이상 매칭할 수 없습니다.");
        }
        return new SelectFunctionStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}
