package pairmatching.exception;

public class EmptyMatchedCrewException extends BusinessException {

    private static final String ERROR_MESSAGE = "매칭 이력이 없습니다.";

    public EmptyMatchedCrewException() {
        super(ERROR_MESSAGE);
    }
}
