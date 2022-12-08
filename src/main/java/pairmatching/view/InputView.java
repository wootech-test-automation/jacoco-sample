package pairmatching.view;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.launcher.code.FeatureCommand;

public class InputView extends IoPrinter {

    public FeatureCommand readFeatureCommand() {
        this.println("기능을 선택하세요.");
        this.println(FeatureCommand.messages());
        return FeatureCommand.from(readLine());
    }

    public String readPairmatchingDivision() {
        return this.readLine();
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException("더 이상 입력할 수 없습니다.");
        }
    }

    private String readLineBeforeNewLine() {
        this.println();
        return this.readLine();
    }


}
