package pairmatching.domain.type;

public class CourseLevelMission {
    Course course;
    Level level;
    Mission mission;

    public CourseLevelMission(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    // TODO too many lines
    public CourseLevelMission(String input) {
        int i = 0;
        for (String s : input.split(",")) {
            s = s.trim();
            if (i == 0) {
                course = Course.of(s);
            }
            if (i == 1) {
                level = Level.of(s);
            }
            if (i == 2) {
                mission = Mission.of(s);
            }
            i++;
        }
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
