package pairmatching.domain.enums;

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
}
