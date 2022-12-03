package pairmatching.domain.command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.utils.ValueChecker;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");


    private static final ValueChecker valueChecker = ValueChecker.createFromRightValues(addRightValues());
    public String command;

    static List<String> addRightValues() {
        return Arrays.stream(Level.values())
                .map(level -> level.command)
                .collect(Collectors.toList());
    }


    public static Level of(String message) {
        valueChecker.validate(message);
        return Arrays.stream(Level.values())
                .filter(level -> level.command.equals(message))
                .findFirst()
                .get();
    }

    Level(String command) {
        this.command = command;
    }
}
