package pairmatching.domain.type;

import java.util.Arrays;
import java.util.Objects;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course of(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> Objects.equals(course.getName(), name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("course 값이 잘못되었씁니다. " + name));
    }

    public boolean isBackend() {
        return this == BACKEND;
    }

    private String getName() {
        return name;
    }
}
