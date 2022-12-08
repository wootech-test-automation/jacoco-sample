package pairmatching.domain.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private final String name;
    private final String fileName;

    Course(final String name, final String fileName) {
        this.name = name;
        this.fileName = fileName;
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

    public String getFileName() {
        return this.fileName;
    }
}
