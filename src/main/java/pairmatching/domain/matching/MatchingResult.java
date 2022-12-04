package pairmatching.domain.matching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingResult {
    private final Map<MatchingDivision, MatchedCrews> matchingResult = new HashMap<>();

    public void matchPair(MatchingDivision matchingDivision, List<Crew> crews) {
        validateMatchingCrewSize(crews.size());
        validateBeforeMatchingCrew(matchingDivision);

        var matchedCrews = new MatchedCrews(crews);

        this.validateSameMatchingCrew(matchingDivision, matchedCrews);
        this.matchingResult.put(matchingDivision, matchedCrews);
    }

    private void validateMatchingCrewSize(int size) {
        if (size < 2) {
            throw new IllegalStateException("페어를 매칭하는 최소인원은 2명입니다.");
        }
    }

    private void validateBeforeMatchingCrew(MatchingDivision matchingDivision) {
        if (this.matchingResult.containsKey(matchingDivision)) {
            throw new IllegalStateException("이미 기록이 존재합니다.");
        }
    }


    private void validateSameMatchingCrew(MatchingDivision matchingDivision, MatchedCrews matchedCrews) {
        var result = matchingResult.entrySet().stream()
                .filter(matchedCrewsEntry -> matchedCrewsEntry.getKey().isSameLevel(matchingDivision))
                .anyMatch(matchedCrewsEntry -> matchedCrewsEntry.getValue().isBeforeMatchingCrews(matchedCrews));
        if (result) {
            throw new IllegalStateException("이전에 매칭된 경험이 있는 크루입니다.");
        }
    }

    public String findMatchingPair(MatchingDivision matchingDivision) {
        if (this.matchingResult.containsKey(matchingDivision)) {
            return this.matchingResult.get(matchingDivision).result();
        }
        throw new IllegalArgumentException("매칭된 페어가 없습니다");
    }
}
