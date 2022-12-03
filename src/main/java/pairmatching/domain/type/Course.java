package pairmatching.domain.type;

import java.util.stream.Stream;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String INVALID_COURSE_NAME = "존재하지 않는 과정을 입력하셨습니다. ex) 백엔드, 프론트엔드";
    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static Course matchOf(String name) {
        return Stream.of(Course.values())
                .filter(course -> name.equals(course.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COURSE_NAME));
    }
}
