package pairmatching.exception;

public class DuplicatedMatchingDivisionException extends RuntimeException {

    public DuplicatedMatchingDivisionException(final String message) {
        super(message);
    }

    public DuplicatedMatchingDivisionException() {
        super("");
    }
}
