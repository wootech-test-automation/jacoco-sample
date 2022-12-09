package pairmatching.exception;

public class BeforeMatchedCrewException extends RuntimeException {
    public BeforeMatchedCrewException(final String message) {
        super(message);
    }

    public BeforeMatchedCrewException() {
        super("");
    }
}
