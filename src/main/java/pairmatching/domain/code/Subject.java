package pairmatching.domain.code;

import java.util.Arrays;

public enum Subject implements InputCommand {
    RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    SHOPPING("장바구니"),
    PAYMENTS("결제"),
    SUBWAY("지하철노선도"),
    IMPROVEMENT_PERFORMANCE("성능개선"),
    DEPLOY("배포");

    private final String name;

    Subject(final String name) {
        this.name = name;
    }

    public static Subject of(final String input) {
        return Arrays.stream(values())
                .filter(subject -> subject.name.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE + input)));
    }

    public String getName() {
        return this.name;
    }
}
