package pairmatching.controller;

import java.util.List;
import pairmatching.exception.NoPariResultException;
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
    }

    private void requestPairMatching() {
        List<String> courseInformation = InputValidator.validateCourseInformation(inputView.inputCourseInformation());
        try {
            outputView.printPairMatchingResult(pairMatchingService.pairMatch(courseInformation));
            run();
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
                outputView.printPairMatchingResult(pairMatchingService.retryPairMatching(courseInformation));
                run();
            }
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestRetry(courseInformation);
        }
    }

    private void requestPairView() {
        try {
            List<String> courseInformation = InputValidator.validateCourseInformation(
                    inputView.inputCourseInformation());
            outputView.printPairMatchingResult(pairMatchingService.findPairMatchResult(courseInformation));
            run();
        } catch (NoPariResultException exception) {
            outputView.printMessage(exception.getMessage());
            run();
        } catch (IllegalArgumentException exception) {
            outputView.printMessage(exception.getMessage());
            requestPairView();
        }
    }

    private void requestPairReset() {
        outputView.printResetMessage();
        pairMatchingService.deleteAllMatchingResult();
        run();
    }
}
