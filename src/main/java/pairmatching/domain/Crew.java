package pairmatching.domain;

import pairmatching.domain.command.CourseCommand;

public class Crew {

    private CourseCommand courseCommand;
    private String name;

    public Crew(CourseCommand courseCommand, String name) {
        this.courseCommand = courseCommand;
        this.name = name;
    }

    public CourseCommand getCourseCommand() {
        return courseCommand;
    }

    public String getName() {
        return name;
    }
}
