package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum LevelCommand {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");


    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;

    static List<String> addRightValues() {
        return Arrays.stream(LevelCommand.values())
                .map(command -> command.command)
                .collect(Collectors.toList());
    }


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
