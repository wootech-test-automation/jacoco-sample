package pairmatching.system.status;

import pairmatching.system.PairmatchingContext;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public interface PairmatchingStatus {
    PairmatchingStatus next(PairmatchingContext pairmatchingContext, InputView inputView, OutputView outputView);

    boolean runnable();
}
