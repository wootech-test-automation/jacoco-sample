package pairmatching.domain;

import java.util.List;
import pairmatching.domain.command.Function;
import pairmatching.domain.command.Rematching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private final PairMatchingService pairMatchingService;

    public PairMatchingApplication(InputView inputView, OutputView outputView,
                                   PairMatchingService pairMatchingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairMatchingService = pairMatchingService;
    }

    public void run() {
        Function functionCommand = startLogic(sendFunctionCommand());
        if (isNotQuit(functionCommand)) {
            run();
        }
    }

    private Function startLogic(Function functionCommand) {
        if (isPairMatching(functionCommand)) {
            return pairMatching(functionCommand);
        }
        if (isPairSearch(functionCommand)) {
            return pairSearch(functionCommand);
        }
        if (isPairReset(functionCommand)) {
            return pairReset(functionCommand);
        }
        return functionCommand;
    }

    private Function pairMatching(Function functionCommand) {
        PairOption pairOption = sendPairOption();
        if (hasPairMatchingResult(pairOption)) {
            Rematching rematchingCommand = sendWhetherToReMatching();
            if (isNotRematching(rematchingCommand)) {
                return pairMatching(functionCommand);
            }

        }
        List<Pair> match = pairMatchingService.match(pairOption);
        outputView.printPairMatchingResult(match);
        return functionCommand;
    }

    private Function pairSearch(Function functionCommand) {
        PairOption pairOption = sendPairOption();
        List<Pair> pairResult = pairMatchingService.getPairResult(pairOption);
        outputView.printPairMatchingResult(pairResult);
        return functionCommand;
    }

    private Function pairReset(Function functionCommand) {
        pairMatchingService.resetMatchResult();
        outputView.printResetMessage();
        return functionCommand;
    }


    private Rematching sendWhetherToReMatching() {
        return inputView.selectWhetherToReMatching();
    }

    private boolean isNotQuit(Function functionCommand) {
        return !functionCommand.equals(Function.QUIT);
    }

    private boolean hasPairMatchingResult(PairOption pairOption) {
        return pairMatchingService.hasMatchResult(pairOption);
    }

    private Function sendFunctionCommand() {
        return inputView.selectProgramFunction();
    }

    private boolean isNotRematching(Rematching rematchingCommand) {
        return rematchingCommand.equals(Rematching.CANCEL);
    }

    private PairOption sendPairOption() {
        return inputView.selectSpecificPairOption();
    }

    private boolean isPairMatching(Function functionCommand) {
        return functionCommand.equals(Function.PAIR_MATCH);
    }

    private boolean isPairSearch(Function functionCommand) {
        return functionCommand.equals(Function.PAIR_SEARCH);
    }

    private boolean isPairReset(Function functionCommand) {
        return functionCommand.equals(Function.PAIR_RESET);
    }
}
