package pairmatching.domain.generator;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.code.Course;
import pairmatching.domain.matching.Crew;

public class CrewGenerator {
    private final ReadFile readFile;
    private final ShuffleGenerator shuffleGenerator;


    public CrewGenerator(ReadFile readFile, ShuffleGenerator shuffleGenerator) {
        this.readFile = readFile;
        this.shuffleGenerator = shuffleGenerator;
    }

    public List<Crew> generateCrews(Course course) {
        var crewNames = this.readFileByCrews(course.getFileName());

        var generatedCrews = this.shuffleGenerator.shuffle(crewNames)
                .stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());

        validateCrewSizeIsGreaterThanMinSize(generatedCrews.size());
        validateDuplicatedCrew(generatedCrews);

        return generatedCrews;
    }

    private void validateDuplicatedCrew(List<Crew> generatedCrews) {
        if (generatedCrews.size() != new HashSet<>(generatedCrews).size()) {
            throw new IllegalStateException();
        }
    }

    private void validateCrewSizeIsGreaterThanMinSize(int size) {
        if (size < 2) {
            throw new IllegalStateException();
        }
    }

    private List<String> readFileByCrews(final String fileName) {
        return readFile.readFile(fileName);
    }
}
