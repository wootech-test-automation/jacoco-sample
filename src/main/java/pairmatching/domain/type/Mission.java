package pairmatching.domain.type;


import java.util.stream.Stream;

public enum Mission {
    RACING_CAR(Subject.RACING_CAR, Level.LEVEL1),
    LOTTO(Subject.LOTTO, Level.LEVEL1),
    BASE_BALL(Subject.BASE_BALL, Level.LEVEL1),
    BASKET(Subject.BASKET, Level.LEVEL2),
    CREDIT(Subject.CREDIT, Level.LEVEL2),
    SUBWAY(Subject.SUBWAY, Level.LEVEL2),
    IMPROVEMENT(Subject.IMPROVEMENT, Level.LEVEL4),
    DISTRIBUTE(Subject.DISTRIBUTE, Level.LEVEL4);

    private static final String INVALID_MISSION_NAME = "레벨에 맞는 정확한 미션 이름을 입력해주세요.";
    private final Subject subject;
    private final Level level;

    Mission(Subject subject, Level level) {
        this.subject = subject;
        this.level = level;
    }

    public static Mission matchOf(Level level, Subject subject) {
        return Stream.of(Mission.values())
                .filter(mission -> subject.equals(mission.subject) && level.equals(mission.level))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MISSION_NAME));
    }

    @Override
    public String toString() {
        return level + ":" + subject;
    }
}
