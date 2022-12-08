package pairmatching.domain.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(final String name) {
        this.name = name;
    }

    public static String messages() {
        return Arrays.stream(values())
                .map(course -> course.name)
                .collect(Collectors.joining(" | "));
    }

    public static Course from(String input) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(input.trim()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
