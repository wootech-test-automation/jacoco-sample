package pairmatching.domain;

import pairmatching.domain.command.CourseCommand;
import pairmatching.domain.command.LevelCommand;
import pairmatching.domain.command.MissionCommand;

public class PairOption {

    private final CourseCommand course;
    private final LevelCommand level;
    private final MissionCommand mission;

    public PairOption(CourseCommand course,
                      LevelCommand level,
                      MissionCommand mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public String sendPath() {
        return course.getPath();
    }

    public boolean isSameOption(PairOption other) {
        if (!course.command.equals(other.course.command)) {
            return false;
        }
        if (!level.command.equals(other.level.command)) {
            return false;
        }

        if (!mission.command.equals(other.mission.command)) {
            return false;
        }

        return true;
    }

}
