package pairmatching.domain.type;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum Level {
    LEVEL1("레벨1", List.of(Mission.CAR, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", List.of(Mission.MARKET, Mission.PAY, Mission.BASEBALL)),
    LEVEL3("레벨3", List.of()),
    LEVEL4("레벨4", List.of(Mission.REFACTOR, Mission.RELEASE)),
    LEVEL5("레벨5", List.of());

    private String name;
    private List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
    }

    public static Level of(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> Objects.equals(level.getName(), name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("level 값이 잘못되었씁니다. " + name));
    }

    private String getName() {
        return name;
    }
}
