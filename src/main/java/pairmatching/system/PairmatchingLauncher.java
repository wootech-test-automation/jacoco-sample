package pairmatching.system;

import pairmatching.system.status.InitStatus;
import pairmatching.system.status.PairmatchingStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingLauncher {

    private final PairmatchingContext pairtmatchingContext;
    private final InputView inputView;
    private final OutputView outputView;

    private final PairmatchingStatus pairmatchingStatus = new InitStatus();

    public PairmatchingLauncher(final PairmatchingContext pairmatchingContext, final InputView inputView,
                                final OutputView outputView) {
        this.pairtmatchingContext = pairmatchingContext;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        while (pairmatchingStatus.runnable()) {
            pairmatchingStatus.next(pairtmatchingContext, inputView, outputView);
        }

    }
}
