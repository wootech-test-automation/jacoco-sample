package pairmatching.domain.matching;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchedCrew {
    private final Set<Crew> matchedCrew;

    public MatchedCrew(List<Crew> shuffledCrew) {
        this.matchedCrew = new LinkedHashSet<>(shuffledCrew);
        if (this.matchedCrew.size() != shuffledCrew.size()) {
            throw new IllegalStateException("파일내 중복된 크루가 존재합니다");
        }
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
}
