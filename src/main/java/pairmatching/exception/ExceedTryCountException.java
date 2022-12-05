package pairmatching.exception;

public class ExceedTryCountException extends BusinessException {

    private static final String ERROR_MESSAGE = "%d 시도했지만 더 이상 매칭할 수 없습니다.";

    public ExceedTryCountException(int tryCount) {
        super(String.format(ERROR_MESSAGE, tryCount));
    }
}
