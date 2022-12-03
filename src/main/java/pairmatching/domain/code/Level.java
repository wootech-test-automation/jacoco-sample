package pairmatching.domain.code;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    public static final String DID_NOT_EIXSTS_LEVEL_NAME = "존재하지 않는 입력입니다 :";
    private static final String ERROR_MESSAGE = DID_NOT_EIXSTS_LEVEL_NAME + "[%s]";
    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static Level of(final String input) {
        var findInput = input.replaceAll(" ", "");
        return Arrays.stream(values()).filter(level -> level.name.equals(findInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, input)));
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }
}
