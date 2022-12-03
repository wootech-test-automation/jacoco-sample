package pairmatching.domain.type;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Mission {
    RACING_CAR("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASE_BALL("숫자야구게임", Level.LEVEL1),
    BASKET("장바구니", Level.LEVEL2),
    CREDIT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    IMPROVEMENT("성능개선", Level.LEVEL4),
    DISTRIBUTE("배포", Level.LEVEL4);

    private static final String INVALID_MISSION_NAME = "레벨에 맞는 정확한 미션 이름을 입력해주세요.";
    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission matchOf(String name) {
        return Stream.of(Mission.values())
                .filter(mission -> name.equals(mission.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MISSION_NAME));
    }

    public static Mission matchOf(String name, Level level) {
        return Stream.of(Mission.values())
                .filter(mission -> name.equals(mission.name) && level.equals(mission.level))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MISSION_NAME));
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return level + ":" + name;
    }
}
