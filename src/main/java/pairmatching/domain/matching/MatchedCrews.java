package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchedCrews {
    private final List<MatchedCrew> matchedCrewList;

    public MatchedCrews() {
        this.matchedCrewList = new ArrayList<>();
    }

    public void add(MatchedCrew matchedCrew) {
        this.matchedCrewList.add(matchedCrew);
    }

    public String result() {
        return this.matchedCrewList.stream()
                .map(MatchedCrew::result)
                .collect(Collectors.joining("\n"));
    }
}
