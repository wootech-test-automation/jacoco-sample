package pairmatching.launcher;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public interface PairmatchingStatus {

    PairmatchingStatus next(Context pairmatchingContext, InputView inputView, OutputView outputView);

    boolean runnable();
}
