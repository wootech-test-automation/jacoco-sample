package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import pairmatching.code.FeaturesCommandCode;

public class InputView extends IoPrinter {

    public FeaturesCommandCode readFeatureCommand() {
        this.println("기능을 선택하세요.");
        this.println(FeaturesCommandCode.getMessages());
        return FeaturesCommandCode.of(readLine());
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException();
        }
    }
}
