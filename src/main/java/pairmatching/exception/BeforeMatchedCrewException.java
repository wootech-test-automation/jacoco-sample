package pairmatching.exception;

public class BeforeMatchedCrewException extends RuntimeException {
    public BeforeMatchedCrewException(final String message) {
        super(message);
    }

    public BeforeMatchedCrewException() {
        super("이전에 매칭된 경험이 있는 크루가 존재합니다.");
    }
}
