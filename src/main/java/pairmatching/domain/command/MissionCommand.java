package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum MissionCommand {

    RACING("자동차경주", LevelCommand.LEVEL1.command),
    LOTTO("로또", LevelCommand.LEVEL1.command),
    BASEBALL("숫자야구게임", LevelCommand.LEVEL1.command),
    SHOPPING("장바구니", LevelCommand.LEVEL2.command),
    PAY("결제", LevelCommand.LEVEL2.command),
    SUBWAY("지하철노선도", LevelCommand.LEVEL2.command),
    PERFORMANCE("성능개선", LevelCommand.LEVEL4.command),
    DISTRIBUTE("배포", LevelCommand.LEVEL4.command);

    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;
    public String level;

    public static MissionCommand from(String message,
                                      String level) {
        valueChecker.validate(message);
        MissionCommand missionCommand = Arrays.stream(MissionCommand.values())
                .filter(mission -> mission.command.equals(message))
                .findFirst()
                .get();
        validateLevel(level, missionCommand);
        return missionCommand;
    }

    private static void validateLevel(String level, MissionCommand missionCommand) {
        if (!missionCommand.level.equals(level)) {
            throw new IllegalArgumentException("미션의 레벨과 입력한 레벨이 일치하지 않습니다. 입력값 : " + level +
                    ", 미션 레벨 : " + missionCommand.command);
        }
    }

    static List<String> addRightValues() {
        return Arrays.stream(MissionCommand.values())
                .map(command -> command.command)
                .collect(Collectors.toList());
    }

    MissionCommand(String command, String level) {
        this.command = command;
        this.level = level;
    }
}
