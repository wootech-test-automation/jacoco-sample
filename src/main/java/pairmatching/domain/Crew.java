package pairmatching.domain;

import pairmatching.domain.enums.Course;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(final Course course, final String name) {
        this.course = course;
        this.name = name;
    }
}
