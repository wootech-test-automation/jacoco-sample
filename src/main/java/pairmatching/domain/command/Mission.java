package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum Mission {

    RACING("자동차경주", Level.LEVEL1.command),
    LOTTO("로또", Level.LEVEL1.command),
    BASEBALL("숫자야구게임", Level.LEVEL1.command),
    SHOPPING("장바구니", Level.LEVEL2.command),
    PAY("결제", Level.LEVEL2.command),
    SUBWAY("지하철노선도", Level.LEVEL2.command),
    PERFORMANCE("성능개선", Level.LEVEL4.command),
    DISTRIBUTE("배포", Level.LEVEL4.command);

    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;
    public String level;

    public static Mission from(String message,
                               String level) {
        valueChecker.validate(message);
        Mission missionCommand = Arrays.stream(Mission.values())
                .filter(mission -> mission.command.equals(message))
                .findFirst()
                .get();
        validateLevel(level, missionCommand);
        return missionCommand;
    }

    private static void validateLevel(String level, Mission missionCommand) {
        if (!missionCommand.level.equals(level)) {
            throw new IllegalArgumentException("미션의 레벨과 입력한 레벨이 일치하지 않습니다. 입력한 미션 레벨 : " + level +
                    ", 해당 미션의 레벨 : " + missionCommand.level);
        }
    }

    static List<String> addRightValues() {
        return Arrays.stream(Mission.values())
                .map(mission -> mission.command)
                .collect(Collectors.toList());
    }

    Mission(String command, String level) {
        this.command = command;
        this.level = level;
    }
}
