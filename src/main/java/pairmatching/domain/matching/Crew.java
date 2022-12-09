package pairmatching.domain.matching;

import java.util.Objects;
import pairmatching.domain.code.Course;

public class Crew {
    private static final int MIN_SIZE = 1;
    private final Course course;
    private final String name;

    public Crew(Course course, String name) {
        var tempName = name.trim();
        validateNameSizeIsGreaterThanMinSize(tempName.length());
        this.course = course;
        this.name = name;
    }

    private void validateNameSizeIsGreaterThanMinSize(int length) {
        if (length < MIN_SIZE) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public boolean equals(Object o) {
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

    public String name() {
        return this.name;
    }
}
