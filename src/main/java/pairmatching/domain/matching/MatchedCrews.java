package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.List;

public class MatchedCrews {
    private final List<MatchedCrew> matchedCrewList;

    public MatchedCrews() {
        this.matchedCrewList = new ArrayList<>();
    }


    public void add(MatchedCrew matchedCrew) {
        this.matchedCrewList.add(matchedCrew);
    }
}
