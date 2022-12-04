package pairmatching.code;

import java.util.Arrays;

public enum Course implements InputCommand {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(final String name) {
        this.name = name;
    }

    public static Course of(final String input) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, input)));
    }
}
