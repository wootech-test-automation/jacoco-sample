package pairmatching.domain.matching;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchedCrew {
    private final Set<Crew> matchedCrew;

    public MatchedCrew() {
        this.matchedCrew = new LinkedHashSet<>();
    }

    public void add(Crew crew) {
        this.matchedCrew.add(crew);
    }

    public void addAll(List<Crew> crews) {
        this.matchedCrew.addAll(crews);
    }

    public String result() {
        return matchedCrew.stream()
                .map(Crew::name)
                .collect(Collectors.joining(" : "));
    }

    public boolean hasMatchedAtBefore(List<MatchedCrew> targetMatchedCrews) {
        return targetMatchedCrews.stream()
                .anyMatch(targetMatchedCrew -> targetMatchedCrew.hasMatchedAtBefore(this));
    }

    private boolean hasMatchedAtBefore(MatchedCrew matchedCrew) {
        var union = new HashSet<>(matchedCrew.matchedCrew);
        union.retainAll(this.matchedCrew);
        return union.size() >= 2;
    }
}
