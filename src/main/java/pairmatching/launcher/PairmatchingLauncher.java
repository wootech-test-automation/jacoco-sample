package pairmatching.launcher;

import pairmatching.launcher.status.InitStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingLauncher {
    private final InputView inputView;
    private final OutputView outputView;
    private final Context context;
    private PairmatchingStatus pairmatchingStatus = new InitStatus();

    public PairmatchingLauncher() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.context = new Context();


    }

    public void execute() {
        while (pairmatchingStatus.runnable()) {
            pairmatchingStatus = pairmatchingStatus.next(context, inputView, outputView);
        }
    }
}
