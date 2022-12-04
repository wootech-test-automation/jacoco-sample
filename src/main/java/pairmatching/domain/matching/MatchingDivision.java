package pairmatching.domain.matching;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import pairmatching.domain.code.Course;
import pairmatching.domain.code.InputCommand;
import pairmatching.domain.code.Level;
import pairmatching.domain.code.Mission;
import pairmatching.domain.code.Subject;

public class MatchingDivision implements InputCommand {

    private final Course course;
    private final Level level;
    private final Subject subject;

    public MatchingDivision(final String input) {
        var splitStr = input.split(",");

        validateInputSize(splitStr);

        this.course = Course.of(splitStr[0]);
        this.level = Level.of(splitStr[1]);
        this.subject = Subject.of(splitStr[2]);

        Mission.validateExistsSubjectInLevel(level, subject);
    }

    public boolean isSameLevel(MatchingDivision matchingDivision) {
        return level.equals(matchingDivision.level);
    }

    private void validateInputSize(String[] result) {
        if (result.length != 3) {
            throw new IllegalArgumentException(ERROR_MESSAGE + result.length);
        }
    }

    public List<Crew> getShuffledCrew() {
        return course.findCrewByCourses()
                .stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
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
