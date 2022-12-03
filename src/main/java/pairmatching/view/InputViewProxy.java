package pairmatching.view;

import java.util.Map;
import pairmatching.domain.command.FunctionCommand;
import pairmatching.domain.command.RematchingCommand;

/**
 * 에러시 입력값을 다시 받도록 해주는 클래스
 */
public class InputViewProxy extends InputView{

    private final InputView inputView;

    public InputViewProxy(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public FunctionCommand selectProgramFunction() {
        try {
            return inputView.selectProgramFunction();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return selectProgramFunction();
        }
    }

    @Override
    public Map<String, Object> selectSpecificPairOption() {
        try {
            return inputView.selectSpecificPairOption();
        } catch (IllegalArgumentException exception) {
            printExceptionMessage(exception.getMessage());
            return selectSpecificPairOption();
        }
    }

    @Override
    public RematchingCommand selectWhetherToReMatching() {
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
