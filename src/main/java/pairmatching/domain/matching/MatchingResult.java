package pairmatching.domain.matching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import pairmatching.exception.DuplicatedMatchingDivisionException;
import pairmatching.exception.MatchingDivisionDidNotExists;

public class MatchingResult {
    private final Map<MatchingDivision, MatchedCrews> matchingResult;

    public MatchingResult() {
        this.matchingResult = new HashMap<>();
    }

    public void matchPair(MatchingDivision matchingDivision, List<Crew> crews) {
        validateDuplicatedKey(matchingDivision);

        this.matchingResult.put(matchingDivision, generateMatchedCrews(new LinkedList<>(crews)));
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
