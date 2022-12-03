package pairmatching.view;

import pairmatching.domain.PairOption;
import pairmatching.domain.command.Function;
import pairmatching.domain.command.Rematching;

/**
 * 에러시 입력값을 다시 받도록 해주는 클래스
 */
public class InputViewProxy extends InputView{

    private final InputView inputView;

    public InputViewProxy(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public Function selectProgramFunction() {
        try {
            return inputView.selectProgramFunction();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return selectProgramFunction();
        }
    }

    @Override
    public PairOption selectSpecificPairOption() {
        try {
            return inputView.selectSpecificPairOption();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return selectSpecificPairOption();
        }
    }

    @Override
    public Rematching selectWhetherToReMatching() {
        try {
            return inputView.selectWhetherToReMatching();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return selectWhetherToReMatching();
        }
    }

    private void printExceptionMessage(String defaultMessage) {
        System.out.println("[ERROR] " + defaultMessage);
    }
}
