package pairmatching.domain.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static String names() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.joining(" | "));
    }

    private String getName() {
        return name;
    }
    // 추가 기능 구현
}