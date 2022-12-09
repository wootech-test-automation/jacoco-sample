package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import pairmatching.domain.matching.MatchingDivision;
import pairmatching.launcher.code.FeatureCommand;
import pairmatching.launcher.code.RematchingCommand;

public class InputView extends IoPrinter {

    public FeatureCommand readFeatureCommand() {
        this.println("기능을 선택하세요.");
        this.println(FeatureCommand.messages());
        return FeatureCommand.from(this.readLineAfterPrintNewLine());
    }

    public MatchingDivision readPairmatchingDivision() {

        this.println("과정, 레벨, 미션을 선택하세요.");
        this.println("ex) 백엔드, 레벨1, 자동차경주");
        return new MatchingDivision(this.readLineAfterPrintNewLine());
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException("더 이상 입력할 수 없습니다.");
        }
    }

    public RematchingCommand readReMatchingCommand() {
        this.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        this.println(RematchingCommand.message());
        return RematchingCommand.from(this.readLineAfterPrintNewLine());
    }

    private String readLineAfterPrintNewLine() {
        var input = this.readLine();
        this.println();
        return input;
    }
}
