package pairmatching.matching;

import java.util.HashSet;
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

    public boolean isBeforeMatchingCrews(MatchedCrew targetMatchedCrews) {
        var union = new HashSet<>(matchedCrew);
        union.retainAll(targetMatchedCrews.matchedCrew);
        return union.size() >= 2;
    }

    // 3 2
    // 3 2
    // []
    // 3 1 2
    // 4 1 2
    // 3
    // 3 2 1
    // 3 2
    // 1
}
