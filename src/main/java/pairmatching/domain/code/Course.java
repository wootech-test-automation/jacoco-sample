package pairmatching.domain.code;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");


    public static final String ERROR_DID_NOT_EXISTS_COURSE = "해당 과정명이 존재하지 않습니다 :";
    private static final String ERROR_MESSAGE_FORMAT = ERROR_DID_NOT_EXISTS_COURSE + "%s";
    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static String names() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.joining(" | "));
    }

    public static Course of(final String input) {
        var findInput = input.replaceAll(" ", "");
        return Arrays.stream(values()).filter(course -> course.name.equals(findInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE_FORMAT, input)));
    }
    // 추가 기능 구현

    private String getName() {
        return name;
    }

    public boolean isBackend() {
        return this == BACKEND;
    }

    public boolean isFrontend() {
        return this == FRONTEND;
    }
}