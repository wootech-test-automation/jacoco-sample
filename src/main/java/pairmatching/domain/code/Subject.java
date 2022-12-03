package pairmatching.domain.code;

import java.util.Arrays;

public enum Subject {
    RACING_GAME("자동차경주"),
    LOTTO_GAME("로또"),
    BASEBALL_NUMBER_GAME("숫자야구게임"),
    SHOPPING("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE_IMPROVEMENTS("성능개선"),
    DEPLOY("배포");

    public static final String DID_NOT_EXISTS_SUBJECT = "해당 과제는 존재하지 않습니다";
    private static final String ERROR_MESSAGE = DID_NOT_EXISTS_SUBJECT + "[input :%s]";
    private final String name;

    Subject(String subjectName) {
        this.name = subjectName;
    }

    public static Subject of(String input) {
        return Arrays.stream(values()).filter(subject -> subject.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, input)));
    }

    public String getName() {
        return name;
    }
}
