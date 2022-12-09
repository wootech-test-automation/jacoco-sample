package pairmatching.launcher;

import pairmatching.domain.generator.CrewGenerator;
import pairmatching.domain.generator.ReadFileImpl;
import pairmatching.domain.generator.ShuffleGeneratorImpl;
import pairmatching.launcher.context.PairmatchingContext;
import pairmatching.launcher.context.PairmatchingContextImpl;
import pairmatching.launcher.status.InitStatus;
import pairmatching.launcher.status.PairmatchingStatus;
import pairmatching.launcher.status.QuitStatus;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;
import pairmatching.view.PairmatchingView;

public class PairmatchingLauncher {
    private final PairmatchingContext pairmatchingContext;
    private PairmatchingStatus pairmatchingStatus;

    public PairmatchingLauncher() {
        this.pairmatchingContext = new PairmatchingContextImpl(new PairmatchingView(new InputView(), new OutputView()),
                new CrewGenerator(new ReadFileImpl(), new ShuffleGeneratorImpl()));

    }

    public void execute() {
        this.pairmatchingStatus = new InitStatus();

        while (pairmatchingStatus.runnable()) {
            try {
                pairmatchingStatus = pairmatchingStatus.next(pairmatchingContext);
            } catch (IllegalArgumentException exception) {
                new OutputView().printError(exception.getMessage());
            } catch (IllegalStateException exception) {
                new OutputView().printError(exception.getMessage());
                pairmatchingStatus = new QuitStatus();
            }
        }

    }
}
