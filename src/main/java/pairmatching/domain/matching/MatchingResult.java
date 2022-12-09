package pairmatching.domain.matching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import pairmatching.exception.BeforeMatchedCrewException;
import pairmatching.exception.DuplicatedMatchingDivisionException;
import pairmatching.exception.MatchingDivisionDidNotExists;

public class MatchingResult {
    private final Map<MatchingDivision, MatchedCrews> matchingResult;

    public MatchingResult() {
        this.matchingResult = new HashMap<>();
    }

    public void matchPair(MatchingDivision matchingDivision, List<Crew> crews) {
        this.validateDuplicatedKey(matchingDivision);

        var matchedResult = generateMatchedCrews(new LinkedList<>(crews));

        this.validateSameLevelExistsMatchedCrew(matchingDivision, matchedResult);
        this.matchingResult.put(matchingDivision, matchedResult);
    }

    public void rematchPair(MatchingDivision matchingDivision, List<Crew> crews) {
        var matchedResult = generateMatchedCrews(new LinkedList<>(crews));

        this.validateSameLevelExistsMatchedCrew(matchingDivision, matchedResult);
        this.matchingResult.put(matchingDivision, matchedResult);
    }

    /**
     * 같은 레벨에서 매칭된 크루가 잇는지 검증합니다.
     *
     * @param matchedResult
     */
    private void validateSameLevelExistsMatchedCrew(MatchingDivision matchingDivision, MatchedCrews matchedResult) {

        var hasSameLevelMatchedCrews = this.matchingResult.entrySet().stream()
                .filter(entry -> entry.getKey().isSameLevel(matchingDivision))
                .anyMatch(entry -> entry.getValue().hasMatchedAtBefore(matchedResult));

        if (hasSameLevelMatchedCrews) {
            throw new BeforeMatchedCrewException();
        }
    }

    private void validateDuplicatedKey(MatchingDivision matchingDivision) {
        if (this.matchingResult.containsKey(matchingDivision)) {
            throw new DuplicatedMatchingDivisionException();
        }
    }

    private MatchedCrews generateMatchedCrews(LinkedList<Crew> crews) {
        var matchedCrews = new MatchedCrews();

        while (crews.size() > 3) {
            matchedCrews.add(generateMatchedCrew(crews, 2));
        }

        matchedCrews.add(generateMatchedCrew(crews, crews.size()));

        return matchedCrews;
    }

    private MatchedCrew generateMatchedCrew(Queue<Crew> crewQueue, final int size) {
        var matchedCrew = new MatchedCrew();
        for (int i = 0; i < size; i++) {
            matchedCrew.add(crewQueue.poll());
        }
        return matchedCrew;
    }

    public String findByMatchingDivision(MatchingDivision matchingDivision) {
        if (!this.matchingResult.containsKey(matchingDivision)) {
            throw new MatchingDivisionDidNotExists();
        }
        return this.matchingResult.get(matchingDivision).result();
    }


}
