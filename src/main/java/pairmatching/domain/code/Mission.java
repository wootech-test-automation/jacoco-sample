package pairmatching.domain.code;

import static pairmatching.domain.code.Subject.BASEBALL_NUMBER_GAME;
import static pairmatching.domain.code.Subject.DEPLOY;
import static pairmatching.domain.code.Subject.LOTTO_GAME;
import static pairmatching.domain.code.Subject.PAYMENT;
import static pairmatching.domain.code.Subject.PERFORMANCE_IMPROVEMENTS;
import static pairmatching.domain.code.Subject.RACING_GAME;
import static pairmatching.domain.code.Subject.SHOPPING;
import static pairmatching.domain.code.Subject.SUBWAY;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {
    MISSION_LEVEL1(Level.LEVEL1, List.of(RACING_GAME, LOTTO_GAME, BASEBALL_NUMBER_GAME)),
    MISSION_LEVEL2(Level.LEVEL2, List.of(SHOPPING, PAYMENT, SUBWAY)),
    MISSION_LEVEL3(Level.LEVEL3, List.of()),
    MISSION_LEVEL4(Level.LEVEL4, List.of(PERFORMANCE_IMPROVEMENTS, DEPLOY)),
    MISSION_LEVEL5(Level.LEVEL5, List.of());

    private static final String MISSION_FORMAT = "  - %s: %s";
    private final Level level;
    private final List<Subject> subjects;

    Mission(Level level, List<Subject> subjects) {
        this.level = level;
        this.subjects = subjects;
    }

    public static String names() {
        return Arrays.stream(Mission.values())
                .map(mission -> String.format(MISSION_FORMAT, mission.level.getName(),
                        mission.subjects.stream().map(Subject::getName).collect(Collectors.joining(" | "))))
                .collect(Collectors.joining("\n"));
    }
}
