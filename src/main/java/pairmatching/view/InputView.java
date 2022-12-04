package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import pairmatching.domain.code.Course;
import pairmatching.domain.code.FeaturesCommandCode;
import pairmatching.domain.code.Mission;
import pairmatching.domain.code.RetryCommand;
import pairmatching.domain.matching.MatchingDivision;

public class InputView extends IoPrinter {

    private static final String COURSE_MESSAGE_FORMAT = "과정 : %s";
    private static final String MISSION_MESSAGE_FORMAT = "미션 : \n%s";
    private static final String DASH_LINE = "#############################################";

    public FeaturesCommandCode readFeatureCommand() {
        this.println("기능을 선택하세요.");
        this.println(FeaturesCommandCode.getMessages());
        return FeaturesCommandCode.of(readLine());
    }

    public MatchingDivision readMatchingDivision() {
        this.println(DASH_LINE);
        this.println(String.format(COURSE_MESSAGE_FORMAT, Course.messages()));
        this.println(String.format(MISSION_MESSAGE_FORMAT, Mission.messages()));
        this.println(DASH_LINE);
        this.println("과정, 레벨, 미션을 선택하세요");
        this.println("ex) 백엔드, 레벨1, 자동차경주");
        return new MatchingDivision(readLineBeforeNextLine());
    }

    public RetryCommand readRetryCommand() {
        this.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        this.println(RetryCommand.message());
        return RetryCommand.of(readLineBeforeNextLine());
    }

    private String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException exception) {
            throw new IllegalStateException();
        }
    }

    private String readLineBeforeNextLine() {
        this.println();
        return this.readLine();
    }


}
