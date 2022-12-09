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
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private PairmatchingStatus pairmatchingStatus = new InitStatus();

    public PairmatchingLauncher() {
        var pairMatchingView = new PairmatchingView(inputView, outputView);
        var crewGenerator = new CrewGenerator(new ReadFileImpl(), new ShuffleGeneratorImpl());

        this.pairmatchingContext = new PairmatchingContextImpl(pairMatchingView, crewGenerator);
    }

    public void execute() {
        while (pairmatchingStatus.runnable()) {
            try {
                pairmatchingStatus = pairmatchingStatus.next(pairmatchingContext);
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            } catch (IllegalStateException exception) {
                outputView.printError(exception.getMessage());
                pairmatchingStatus = new QuitStatus();
            }
        }
    }
}
