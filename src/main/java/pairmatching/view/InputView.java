package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import pairmatching.domain.code.Course;
import pairmatching.domain.code.Level;
import pairmatching.domain.matching.MatchingDivision;
import pairmatching.launcher.code.FeatureCommand;
import pairmatching.launcher.code.RematchingCommand;

public class InputView extends IoPrinter {

    public FeatureCommand readFeatureCommand() {
        this.println("기능을 선택하세요.");
        this.println(FeatureCommand.messages());
        return FeatureCommand.from(readLine());
    }

    public MatchingDivision readPairmatchingDivision() {
        this.println(DIVISION_HASH);
        this.println(String.format("과정 : %s", Course.messages()));
        this.println(Level.messages());
        this.println(DIVISION_HASH);
        this.println("과정, 레벨, 미션을 선택하세요.");
        this.println("ex) 백엔드, 레벨1, 자동차경주");
        return new MatchingDivision(this.readLine());
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


    public RematchingCommand readReMatchingCommand() {
        this.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        this.println(RematchingCommand.message());
        return RematchingCommand.from(this.readLine());
    }
}
