package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.code.Course;
import pairmatching.domain.code.FunctionCommand;
import pairmatching.domain.code.Mission;
import pairmatching.domain.info.PairMatchingSelector;

public class InputView extends IoPrinter {
    private static final String MISSION_FORMAT = "미션:\n%s";
    private static final String COURSE_FORMAT = "과정 : %s";
    private static final String CHOSE_FUNCTION = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    private final String DIVISION_LINE = "#############################################";

    public PairMatchingSelector readPairMatchingSelector() {
        this.println(DIVISION_LINE);
        this.println(String.format(COURSE_FORMAT, Course.names()));
        this.println(String.format(MISSION_FORMAT, Mission.names()));
        this.println(DIVISION_LINE);
        this.println("과정, 레벨, 미션을 선택하세요");
        return new PairMatchingSelector(Console.readLine());
    }

    public FunctionCommand readPairMatchingServiceCommand() {
        this.println(CHOSE_FUNCTION);
        return FunctionCommand.of(Console.readLine());
    }
}
