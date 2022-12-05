package pairmatching.exception;

public class DuplicateException extends BusinessException {

    private static final String ERROR_MESSAGE = "중복된 값이 존재합니다.";

    public DuplicateException() {
        super(ERROR_MESSAGE);
    }
}
