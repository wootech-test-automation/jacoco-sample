package pairmatching.domain.type;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private static final String INVALID_LEVEL_NAME = "레벨 입력이 옳바르지 않습니다.";
    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static Level matchOf(String name) {
        return Stream.of(Level.values())
                .filter(level -> name.equals(level.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_LEVEL_NAME));
    }

    @Override
    public String toString() {
        return name;
    }
}
