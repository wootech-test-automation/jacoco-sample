package pairmatching.domain.enums;

import java.util.Arrays;
import pairmatching.message.ErrorMessage;

public enum Mission {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_PATH("지하철노선도"),
    PERFORMANCE("성능개선"),
    DISTRIBUTION("배포");

    private String name;

    Mission(final String name) {
        this.name = name;
    }

    public static Mission findMission(final String inputMission) {
        return Arrays.stream(values())
                .filter(mission -> mission.containsMission(inputMission))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_MISSION_ERROR));
    }

    private boolean containsMission(final String inputMission) {
        return name.equals(inputMission);
    }
}
