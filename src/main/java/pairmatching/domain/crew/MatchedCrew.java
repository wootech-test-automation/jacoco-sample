package pairmatching.domain.crew;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchedCrew {
    private final Set<Crew> matchedCrew;

    public MatchedCrew(final List<Crew> crews) {
        this.matchedCrew = new LinkedHashSet<>(crews);
    }

    public String result() {
        return matchedCrew.stream()
                .map(Crew::name)
                .collect(Collectors.joining(" : "));
    }

    public boolean isMatched(List<MatchedCrew> matchedCrew) {
        return matchedCrew.stream().anyMatch(targetMatchedCrew -> {
            var intersection = new HashSet<>(targetMatchedCrew.matchedCrew);
            intersection.retainAll(this.matchedCrew);
            return intersection.size() >= 2;
        });
    }

    @Override
    public String toString() {
        return "MatchedCrew{" +
                "matchedCrew=" + matchedCrew +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchedCrew that = (MatchedCrew) o;
        return Objects.equals(matchedCrew, that.matchedCrew);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchedCrew);
    }
}
