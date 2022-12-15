package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.CourseInformation;
import pairmatching.domain.Pair;

public class MatchingCrewRepository {
    private static final MatchingCrewRepository instance = new MatchingCrewRepository();
    private static final Map<CourseInformation, List<Pair>> store = new HashMap<>();

    private MatchingCrewRepository() {
    }

    public static MatchingCrewRepository getInstance() {
        return instance;
    }

    public boolean hasMatchedBefore(CourseInformation courseInformation) {
        return store.containsKey(courseInformation);
    }

    public void savePairMatching(final CourseInformation courseInformation, final List<Pair> pairs) {
        store.remove(courseInformation);
        store.put(courseInformation, pairs);
    }
}
