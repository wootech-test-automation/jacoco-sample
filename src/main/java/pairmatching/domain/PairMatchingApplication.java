package pairmatching.domain;

import java.util.List;
import pairmatching.domain.command.FunctionCommand;
import pairmatching.domain.command.RematchingCommand;
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
        FunctionCommand functionCommand = startLogic(sendFunctionCommand());
        if (isNotQuit(functionCommand)) {
            run();
        }
    }

    private FunctionCommand startLogic(FunctionCommand functionCommand) {
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

    private FunctionCommand pairMatching(FunctionCommand functionCommand) {
        PairOption pairOption = sendPairOption();
        if (hasPairMatchingResult(pairOption)) {
            RematchingCommand rematchingCommand = sendWhetherToReMatching();
            if (isNotRematching(rematchingCommand)) {
                return pairMatching(functionCommand);
            }

        }
        List<Pair> match = pairMatchingService.match(pairOption);
        outputView.printPairMatchingResult(match);
        return functionCommand;
    }

    private FunctionCommand pairSearch(FunctionCommand functionCommand) {
        PairOption pairOption = sendPairOption();
        List<Pair> pairResult = pairMatchingService.getPairResult(pairOption);
        outputView.printPairMatchingResult(pairResult);
        return functionCommand;
    }

    private FunctionCommand pairReset(FunctionCommand functionCommand) {
        pairMatchingService.resetMatchResult();
        outputView.printResetMessage();
        return functionCommand;
    }


    private RematchingCommand sendWhetherToReMatching() {
        return inputView.selectWhetherToReMatching();
    }

    private boolean isNotQuit(FunctionCommand functionCommand) {
        return !functionCommand.equals(FunctionCommand.QUIT);
    }

    private boolean hasPairMatchingResult(PairOption pairOption) {
        return pairMatchingService.hasMatchResult(pairOption);
    }

    private FunctionCommand sendFunctionCommand() {
        return inputView.selectProgramFunction();
    }

    private boolean isNotRematching(RematchingCommand rematchingCommand) {
        return rematchingCommand.equals(RematchingCommand.CANCEL);
    }

    private PairOption sendPairOption() {
        return inputView.selectSpecificPairOption();
    }

    private boolean isPairMatching(FunctionCommand functionCommand) {
        return functionCommand.equals(FunctionCommand.PAIR_MATCH);
    }

    private boolean isPairSearch(FunctionCommand functionCommand) {
        return functionCommand.equals(FunctionCommand.PAIR_SEARCH);
    }

    private boolean isPairReset(FunctionCommand functionCommand) {
        return functionCommand.equals(FunctionCommand.PAIR_RESET);
    }
}
