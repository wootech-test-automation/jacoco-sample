package pairmatching.domain.checker;

import java.util.List;
import pairmatching.db.Database;
import pairmatching.domain.type.MatchingInformation;
import pairmatching.domain.type.Pair;
import pairmatching.exception.DuplicateException;
import pairmatching.exception.DuplicatePairException;

public class DefaultDuplicateChecker implements DuplicateChecker {

    private final Database database;

    public DefaultDuplicateChecker(Database database) {
        this.database = database;
    }

    @Override
    public void checkDuplicate(MatchingInformation matchingInformation) {
        if (database.exist(matchingInformation)) {
           throw new DuplicateException();
        }
    }

    @Override
    public void checkDuplicatePair(String inputKey, List<Pair> pairs) {
        boolean duplicatePair = pairs.stream().anyMatch(pair -> database.existPair(inputKey, pair));
        if (duplicatePair) {
            throw new DuplicatePairException();
        }
    }
}
