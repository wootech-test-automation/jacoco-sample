package pairmatching.controller;

import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            determineMenuSelect(InputValidator.validateSelectMenu(inputView.inputSelectMenu()));
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            run();
        }
    }

    private void determineMenuSelect(final String validatedSelectMenu) {
        if (validatedSelectMenu.equals(InputValidator.PAIR_MATCHING)) {
            requestPairMatching();
        }
        if (validatedSelectMenu.equals(InputValidator.PAIR_VIEW)) {
            requestPairView();
        }
        if (validatedSelectMenu.equals(InputValidator.PAIR_RESET)) {
            requestPairReset();
        }
    }

    private void requestPairMatching() {
        System.out.println("pass");
    }

    private void requestPairReset() {
        System.out.println("pass");
    }

    private void requestPairView() {
        System.out.println("pass");
    }

}
