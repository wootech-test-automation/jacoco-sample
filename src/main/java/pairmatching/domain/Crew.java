package pairmatching.domain;

import java.util.Objects;
import pairmatching.domain.enums.Course;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(final Course course, final String name) {
        this.course = course;
        this.name = name;
    }

    public boolean containsCourse(final Course course) {
        return this.course == course;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crew crew = (Crew) o;
        return course == crew.course && Objects.equals(name, crew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, name);
    }
}
