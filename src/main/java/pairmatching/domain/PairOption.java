package pairmatching.domain;

import pairmatching.domain.command.Course;
import pairmatching.domain.command.Level;
import pairmatching.domain.command.Mission;

//TODO Eqauls 기능 오버라이드 필요
public class PairOption {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairOption(Course course,
                      Level level,
                      Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public String sendPath() {
        return course.getPath();
    }

    public Course getCourse() {
        return course;
    }
}
