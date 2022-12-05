package pairmatching.domain;

import java.util.List;
import java.util.Set;
import pairmatching.domain.checker.DefaultDuplicateChecker;
import pairmatching.domain.checker.DuplicateChecker;
import pairmatching.db.Database;
import pairmatching.domain.loader.CrewLoader;
import pairmatching.domain.maker.EvenPairMaker;
import pairmatching.domain.maker.OddPairMaker;
import pairmatching.domain.maker.PairMaker;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.MatchingInformation;
import pairmatching.domain.type.Pair;
import pairmatching.exception.EmptyMatchedCrewException;

public class PairMatchingGame {

    private final Database database = new Database();
    private final CrewLoader crewLoader = new CrewLoader();
    private final DuplicateChecker duplicateChecker = new DefaultDuplicateChecker(database);

    public Set<Pair> pairMatch(MatchingInformation matchingInformation) {
        duplicateChecker.checkDuplicate(matchingInformation);
        List<Pair> pairs = makeCrewPairs(matchingInformation);
        database.addAll(matchingInformation, pairs);
        return database.getAll(matchingInformation);
    }

    public Set<Pair> reMatch(MatchingInformation matchingInformation) {
        database.removeKey(matchingInformation);
        List<Pair> pairs = makeCrewPairs(matchingInformation);
        database.addAll(matchingInformation, pairs);
        return database.getAll(matchingInformation);
    }

    public Set<Pair> showPair(MatchingInformation matchingInformation) {
        Set<Pair> pairs = database.getAll(matchingInformation);
        if (pairs.isEmpty()) {
            throw new EmptyMatchedCrewException();
        }
        return pairs;
    }

    public void reset() {
        database.clear();
    }

    private List<Pair> makeCrewPairs(MatchingInformation matchingInformation) {
        List<Crew> names = crewLoader.getNames(matchingInformation.getCourse());
        PairMaker pairMaker = createPairMaker(names.size());
        List<Pair> pairs = pairMaker.createPair(names);
        duplicateChecker.checkDuplicatePair(matchingInformation.getLevel().toString(), pairs);
        return pairs;
    }

    private PairMaker createPairMaker(int number) {
        if (number % 2 == 0) {
            return new EvenPairMaker();
        }
        return new OddPairMaker();
    }
}
