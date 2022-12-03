package pairmatching.domain.info;

import pairmatching.domain.code.Course;
import pairmatching.domain.code.Level;
import pairmatching.domain.code.Subject;

public class PairMatchingSelector {
    public static final String DID_NOT_SPLIT_INPUT = "콤마로 구분할경우 3가지가 입려된 것이 아닙니다.";
    private static final String ERROR_MESSAGE = DID_NOT_SPLIT_INPUT + "[input %s]";
    private final Level level;
    private final Course course;
    private final Subject subject;

    public PairMatchingSelector(final String input) {
        var inputStr = input.split(",");
        validateInputSize(inputStr.length);

        this.course = Course.of(inputStr[0]);
        this.level = Level.of(inputStr[1]);
        this.subject = Subject.of(inputStr[2]);
    }

    private void validateInputSize(int size) {
        if (size != 3) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, size));
        }
    }


    public Course getCourse() {
        return course;
    }

    public boolean isBackend() {
        return course.isBackend();
    }

    public boolean isSameLevel(PairMatchingSelector pairMatchingSelector) {
        return this.course.equals(pairMatchingSelector.course);
    }
}
