package pairmatching.matching;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.code.Course;
import pairmatching.code.InputCommand;
import pairmatching.code.Level;
import pairmatching.code.Mission;
import pairmatching.code.Subject;

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
}
