package pairmatching.system;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingLauncher {

    private final PairmatchingContext pairtmatchingContext;
    private final InputView inputView;
    private final OutputView outputView;

    public PairmatchingLauncher(final PairmatchingContext pairtmatchingContext, final InputView inputView,
                                final OutputView outputView) {
        this.pairtmatchingContext = pairtmatchingContext;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {

    }
}
