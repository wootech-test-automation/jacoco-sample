package pairmatching.domain.type;

import java.util.Objects;

public class Crew {
    private final Course course;
    private final Name name;

    public Crew(Course course, Name name) {
        this.course = course;
        this.name = name;
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

    public Course getCourse() {
        return course;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "course=" + course +
                ", name=" + name +
                '}';
    }
}
