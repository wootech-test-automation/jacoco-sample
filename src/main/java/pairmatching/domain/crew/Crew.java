package pairmatching.domain.crew;

import java.util.Objects;
import pairmatching.domain.code.Course;

public class Crew {
    private final Course course;
    private final String name;

    public Crew(Course course, final String name) {
        this.course = course;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "course=" + course +
                ", name='" + name + '\'' +
                '}';
    }

    public String name() {
        return name;
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
}
