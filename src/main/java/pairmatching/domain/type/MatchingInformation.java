package pairmatching.domain.type;

public class MatchingInformation {

    private static final String COMMA = ",";
    private static final int INPUT_SIZE = 3;
    private static final String ERROR_INPUT_SIZE = "입력은 3가지만 입력하세요.";

    private final Course course;
    private final Level level;
    private final Subject subject;
    private final Mission mission;

    private MatchingInformation(Course course, Level level, Subject subject) {
        this.course = course;
        this.level = level;
        this.subject = subject;
        this.mission = Mission.matchOf(level, subject);
    }

    public static MatchingInformation of(String line) {
        String[] split = line.split(COMMA);
        validateSplit(split);
        Course course = Course.matchOf(split[0].trim());
        Level level = Level.matchOf(split[1].trim());
        Subject subject = Subject.matchOf(split[2].trim());
        return new MatchingInformation(course, level, subject);
    }

    private static void validateSplit(String[] split) {
        if (split.length > INPUT_SIZE) {
            throw new IllegalArgumentException(ERROR_INPUT_SIZE);
        }
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Subject getSubject() {
        return subject;
    }

    public Mission getMission() {
        return mission;
    }

    @Override
    public String toString() {
        return course + "," + level + "," + subject;
    }
}
