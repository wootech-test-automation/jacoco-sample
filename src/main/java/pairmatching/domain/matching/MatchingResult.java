package pairmatching.domain.matching;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MatchingResult {
    private Map<MatchingDivision, MatchedCrews> matchingResult;

    private static MatchedCrew generateMatchedCrew(Queue<Crew> crewsQueue) {
        var matchedCrew = new MatchedCrew();
        for (int i = 0; i <= 1; i++) {
            matchedCrew.add(crewsQueue.poll());
        }
        return matchedCrew;
    }

    public void matchPair(MatchingDivision matchingDivision, List<Crew> crews) {
        var matchedCrews = new MatchedCrews();
        Queue<Crew> crewsQueue = (Queue) crews;

        while (crewsQueue.size() > 3) {
            MatchedCrew matchedCrew = generateMatchedCrew(crewsQueue);
            matchedCrews.add(matchedCrew);
        }
        var matchedCrew = new MatchedCrew();
        while (!crewsQueue.isEmpty()) {
            matchedCrew.add(crewsQueue.poll());
        }
        matchedCrews.add(matchedCrew);
    }
}
