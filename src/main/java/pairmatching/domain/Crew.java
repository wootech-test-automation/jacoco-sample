package pairmatching.domain;

import pairmatching.domain.command.Course;

public class Crew {

    private Course courseCommand;
    private String name;

    public Crew(Course courseCommand, String name) {
        this.courseCommand = courseCommand;
        this.name = name;
    }

    public Course getCourseCommand() {
        return courseCommand;
    }

    public String getName() {
        return name;
    }
}
