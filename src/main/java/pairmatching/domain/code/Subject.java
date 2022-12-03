package pairmatching.domain.code;

public enum Subject {
    RACING_GAME("자동차경주"),
    LOTTO_GAME("로또"),
    BASEBALL_NUMBER_GAME("숫자야구게임"),
    SHOPPING("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    PERFORMANCE_IMPROVEMENTS("성능개선"),
    DEPLOY("배포");

    private final String name;

    Subject(String subjectName) {
        this.name = subjectName;
    }

    public String getName() {
        return name;
    }
}
