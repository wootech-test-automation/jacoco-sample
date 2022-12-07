package pairmatching.domain.type;

import java.util.Arrays;
import java.util.Objects;

public enum Mission {
    CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    MARKET("장바구니"),
    PAY("결제"),
    METRO("지하철노선도"),
    REFACTOR("성능개선"),
    RELEASE("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission of(String name) {
        return Arrays.stream(Mission.values())
                .filter(mission -> Objects.equals(mission.getName(), name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("mission 값이 잘못되었씁니다. " + name));
    }

    private String getName() {
        return name;
    }
}
