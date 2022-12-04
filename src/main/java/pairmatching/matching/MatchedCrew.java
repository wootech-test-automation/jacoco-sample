package pairmatching.matching;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchedCrew {
    private final Set<Crew> matchedCrew;

    public MatchedCrew(List<Crew> shuffledCrew) {
        this.matchedCrew = new LinkedHashSet<>(shuffledCrew);
    }


    public String result() {
        return matchedCrew.stream()
                .map(Crew::getName)
                .collect(Collectors.joining(" : "));
    }
}
