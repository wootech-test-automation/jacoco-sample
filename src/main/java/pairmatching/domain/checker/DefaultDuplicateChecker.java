package pairmatching.domain.checker;

import java.util.List;
import pairmatching.domain.db.PairDatabase;
import pairmatching.domain.type.Course;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;

public class DefaultDuplicateChecker implements DuplicateChecker {

    private final PairDatabase database;

    public DefaultDuplicateChecker(PairDatabase database) {
        this.database = database;
    }

    @Override
    public boolean isDuplicate(Course course, Mission mission) {
        return database.exist(course, mission);
    }

    @Override
    public boolean isDuplicatePair(String inputKey, List<Pair> pairs) {
        return pairs.stream().anyMatch(pair -> database.existPair(inputKey, pair));
    }
}
