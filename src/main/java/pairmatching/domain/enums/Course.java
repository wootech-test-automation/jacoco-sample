package pairmatching.domain.enums;

import java.util.Arrays;
import pairmatching.message.ErrorMessage;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findCourse(final String inputCourse) {
        return Arrays.stream(Course.values())
                .filter(course -> course.containsName(inputCourse))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_COURSE_ERROR));
    }

    private boolean containsName(final String inputCourse) {
        return name.equals(inputCourse);
    }
}
