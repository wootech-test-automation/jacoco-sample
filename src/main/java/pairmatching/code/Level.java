package pairmatching.code;

import java.util.Arrays;

public enum Level implements InputCommand {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(final String name) {
        this.name = name;
    }

    public static Level of(final String input) {
        return Arrays.stream(values())
                .filter(level -> level.name.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, input)));
    }
}
