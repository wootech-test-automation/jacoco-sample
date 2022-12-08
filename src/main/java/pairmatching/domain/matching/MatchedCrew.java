package pairmatching.domain.matching;

import java.util.LinkedHashSet;
import java.util.Set;

public class MatchedCrew {
    private final Set<Crew> matchedCrew;

    public MatchedCrew() {
        this.matchedCrew = new LinkedHashSet<>();
    }

    public void add(Crew crew) {
        this.matchedCrew.add(crew);
    }
}
