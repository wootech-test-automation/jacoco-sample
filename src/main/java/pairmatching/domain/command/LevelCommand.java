package pairmatching.domain.command;

import java.util.Arrays;
import pairmatching.utils.ValueChecker;

public enum LevelCommand {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String command;
    private static ValueChecker valueChecker =
            ValueChecker.createFromRightValues(LEVEL1.command, LEVEL2.command, LEVEL3.command,
                    LEVEL4.command, LEVEL5.command);

    public static LevelCommand of(String message) {
        valueChecker.validate(message);
        return Arrays.stream(LevelCommand.values())
                .filter(levelCommand -> levelCommand.command.equals(message))
                .findFirst()
                .get();
    }

    LevelCommand(String command) {
        this.command = command;
    }
}
