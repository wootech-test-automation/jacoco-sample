package pairmatching.launcher;

import pairmatching.launcher.context.PairmatchingContext;
import pairmatching.launcher.context.PairmatchingContextImpl;
import pairmatching.launcher.status.InitStatus;
import pairmatching.launcher.status.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.PairmatchingView;

public class PairmatchingLauncher {
    private final PairmatchingContext pairmatchingContext;
    private PairmatchingStatus pairmatchingStatus;

    PairmatchingLauncher() {
        this.pairmatchingContext = new PairmatchingContextImpl(new PairmatchingView(new InputView(), new OutputView()));
        this.pairmatchingStatus = new InitStatus();

    }

    public void execute() {
        while (pairmatchingStatus.runnable()) {
            pairmatchingStatus = pairmatchingStatus.next(pairmatchingContext);
        }

    }
}
