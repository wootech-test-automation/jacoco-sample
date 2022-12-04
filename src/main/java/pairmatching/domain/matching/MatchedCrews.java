package pairmatching.domain.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchedCrews {
    private final List<MatchedCrew> matchedCrewList = new ArrayList<>();

    public MatchedCrews(List<Crew> crews) {
        if (crews.size() % 2 == 0) {
            this.matchedCrewList.addAll(generateMatchedCrewList(crews, crews.size()));
            return;
        }
        var lastSize = crews.size() - 3;
        this.matchedCrewList.addAll(generateMatchedCrewList(crews, lastSize));
        this.matchedCrewList.add(new MatchedCrew(matchPair(crews, lastSize, lastSize + 2)));
    }

    private List<MatchedCrew> generateMatchedCrewList(List<Crew> crews, int size) {
        List<MatchedCrew> matchedCrews = new ArrayList<>();
        for (int i = 0; i < size; i += 2) {
            matchedCrews.add(new MatchedCrew(matchPair(crews, i, i + 1)));
        }
        return matchedCrews;
    }

    private List<Crew> matchPair(List<Crew> crews, int start, int size) {
        List<Crew> matchedCrews = new ArrayList<>();
        for (int i = start; i <= size; i++) {
            matchedCrews.add(crews.get(i));
        }
        return matchedCrews;
    }

    public String result() {
        return matchedCrewList.stream()
                .map(MatchedCrew::result)
                .collect(Collectors.joining("\n"));
    }

    public boolean isBeforeMatchingCrews(MatchedCrews targetMatchedCrews) {
        return this.matchedCrewList.stream()
                .anyMatch(matchedCrew -> isBeforeMatchingCrew(targetMatchedCrews, matchedCrew));
    }

    private boolean isBeforeMatchingCrew(MatchedCrews targetMatchedCrews, MatchedCrew matchedCrew) {
        return targetMatchedCrews.matchedCrewList
                .stream()
                .anyMatch(matchedCrew::isBeforeMatchingCrews);
    }
}
