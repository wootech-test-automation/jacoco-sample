package pairmatching.controller;

import java.util.List;
import pairmatching.exception.PairAlreadyExistException;
import pairmatching.service.PairMatchingService;
import pairmatching.util.InputValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
    public static final String RETRY = "네";
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final PairMatchingService pairMatchingService = new PairMatchingService();

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
        run();
    }

    private void requestPairMatching() {
        List<String> courseInformation = InputValidator.validateCourseInformation(inputView.inputCourseInformation());
        try {
            pairMatchingService.pairMatch(courseInformation);
        } catch (PairAlreadyExistException exception) {
            requestRetry(courseInformation);
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestPairMatching();
        }
    }

    private void requestRetry(final List<String> courseInformation) {
        try {
            if (InputValidator.validateRetryInput(inputView.inputRetry()).equals(RETRY)) {
                pairMatchingService.retryPairMatching(courseInformation);
            }
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestRetry(courseInformation);
        }
    }

    private void requestPairReset() {
        System.out.println("pass");
    }

    private void requestPairView() {
        System.out.println("pass");
    }

}
