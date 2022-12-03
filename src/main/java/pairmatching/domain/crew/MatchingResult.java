package pairmatching.domain.crew;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.domain.file.ReadCrew;
import pairmatching.domain.info.PairMatchingSelector;

public class MatchingResult {
    private final Map<PairMatchingSelector, List<MatchedCrew>> matchingResult = new LinkedHashMap<>();

    public MatchingResult() {

    }

    private List<MatchedCrew> matchPair(PairMatchingSelector pairMatchingSelector, List<Crew> shuffleCrew) {
        validateCrewLength(shuffleCrew);
        List<MatchedCrew> matched = getMatchedCrews(shuffleCrew);
        this.validateIsMatching(matched);
        this.matchingResult.put(pairMatchingSelector, matched);
        return matched;
    }

    private void validateCrewLength(List<Crew> shuffleCrew) {
        if (shuffleCrew.size() < 2) {
            throw new IllegalStateException("매칭 할 수 없습니다");
        }
    }

    private List<MatchedCrew> getMatchedCrews(List<Crew> shuffleCrew) {
        if (shuffleCrew.size() % 2 == 0) {
            return generateEventCountCrew(shuffleCrew);
        }
        return generateOddCountCrew(shuffleCrew);
    }

    private List<MatchedCrew> generateEventCountCrew(List<Crew> shuffleCrew) {
        var matched = new ArrayList<MatchedCrew>();
        for (int i = 0; i < shuffleCrew.size(); i += 2) {
            matched.add(new MatchedCrew(List.of(shuffleCrew.get(i), shuffleCrew.get(i + 1))));
        }
        return matched;
    }

    private List<MatchedCrew> generateOddCountCrew(List<Crew> shuffleCrew) {
        var matched = new ArrayList<MatchedCrew>();
        int lastIndex = 0;
        for (int i = 0; i < shuffleCrew.size() - 3; i += 2) {
            matched.add(new MatchedCrew(List.of(shuffleCrew.get(i), shuffleCrew.get(i + 1))));
            lastIndex = i;
        }
        matched.add(new MatchedCrew(List.of(shuffleCrew.get(lastIndex), shuffleCrew.get(lastIndex + 1),
                shuffleCrew.get(lastIndex + 2))));
        return matched;
    }

    public List<MatchedCrew> addMatching(PairMatchingSelector pairMatchingSelector) {
        var crews = new ReadCrew(pairMatchingSelector.getCourse()).read();
        var shuffle = Randoms.shuffle(crews);
        var shuffleCrew = shuffle.stream().map(s -> new Crew(pairMatchingSelector.getCourse(), s))
                .collect(Collectors.toList());
        return this.matchPair(pairMatchingSelector, shuffleCrew);
    }

    public List<MatchedCrew> searchMatching(PairMatchingSelector pairMatchingSelector) {
        return this.matchingResult.get(pairMatchingSelector);
    }

    public boolean findBeforeMatchingResult(PairMatchingSelector pairMatchingSelector) {
        return this.matchingResult.containsKey(pairMatchingSelector);
    }

    public void validateIsMatching(List<MatchedCrew> matchedCrews) {
        var result = this.matchingResult.entrySet().stream()
                .anyMatch(pairMatchingSelectorListEntry -> pairMatchingSelectorListEntry.getValue().stream()
                        .anyMatch(matchedCrew -> matchedCrew.isMatched(matchedCrews)));
        if (result) {
            throw new IllegalStateException("이전에 매칭된 이력이 있습니다.");
        }

    }
}
