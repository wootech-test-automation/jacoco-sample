package pairmatching.domain.matching;

import java.util.Objects;
import pairmatching.domain.code.Course;
import pairmatching.domain.code.Level;
import pairmatching.domain.code.Subject;

public class MatchingDivision {
    private static final int FIX_SIZE = 3;

    private final Course course;
    private final Level level;
    private final Subject subject;

    public MatchingDivision(String input) {
        var splitStr = input.split(",");
        validateSplitSize(splitStr.length);

        this.course = Course.from(splitStr[0]);
        this.subject = Subject.from(splitStr[2]);
        this.level = Level.from(splitStr[1], this.subject);
    }

    private void validateSplitSize(int length) {
        if (length != FIX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchingDivision that = (MatchingDivision) o;
        return course == that.course && level == that.level && subject == that.subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, subject);
    }
}
