package pairmatching.domain.type;

import java.util.stream.Stream;

public enum Subject {

    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASE_BALL("숫자야구게임"),
    BASKET("장바구니"),
    CREDIT("결제"),
    SUBWAY("지하철노선도"),
    IMPROVEMENT("성능개선"),
    DISTRIBUTE("배포");

    private static final String INVALID_SUBJECT_NAME = "잘못된 과목을 입력하셨습니다.";
    private final String name;

    Subject(String name) {
        this.name = name;
    }

    public static Subject matchOf(String name) {
        return Stream.of(Subject.values())
                .filter(subject -> name.equals(subject.name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_SUBJECT_NAME));
    }

    public String getName() {
        return name;
    }
}
