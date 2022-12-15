package pairmatching.domain;

import java.util.List;
import java.util.Objects;
import pairmatching.domain.enums.Course;
import pairmatching.domain.enums.Level;
import pairmatching.domain.enums.Mission;
import pairmatching.message.ErrorMessage;

public class CourseInformation {
    public static final int COURSE_INDEX = 0;
    public static final int LEVEL_INDEX = 1;
    public static final int MISSION_INDEX = 2;
    private final Course course;
    private final Level level;
    private final Mission mission;

    private CourseInformation(final Course course, final Level level, final Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static CourseInformation of(final List<String> inputInformation) {
        CourseInformation courseInformation = new CourseInformation(
                Course.findCourse(inputInformation.get(COURSE_INDEX)),
                Level.findLevel(inputInformation.get(LEVEL_INDEX)),
                Mission.findMission(inputInformation.get(MISSION_INDEX))
        );
        return validateCourseInformation(courseInformation);
    }

    private static CourseInformation validateCourseInformation(final CourseInformation courseInformation) {
        if (!courseInformation.level.isExistsMission(courseInformation.mission)) {
            throw new IllegalArgumentException(ErrorMessage.NO_MISSION_IN_LEVEL_ERROR);
        }
        return courseInformation;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourseInformation that = (CourseInformation) o;
        return course == that.course && level == that.level && mission == that.mission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }
}
