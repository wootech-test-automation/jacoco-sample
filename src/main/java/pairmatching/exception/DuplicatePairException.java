package pairmatching.exception;

public class DuplicatePairException extends BusinessException {

    private static final String ERROR_MESSAGE = "페어 매칭시 중복이 있습니다";

    public DuplicatePairException() {
        super(ERROR_MESSAGE);
    }
}
