package pairmatching.domain;

import java.util.List;
import pairmatching.domain.checker.DefaultDuplicateChecker;
import pairmatching.domain.checker.DuplicateChecker;
import pairmatching.domain.db.PairDatabase;
import pairmatching.domain.loader.CrewLoader;
import pairmatching.domain.maker.EvenPairMaker;
import pairmatching.domain.maker.OddPairMaker;
import pairmatching.domain.maker.PairMaker;
import pairmatching.domain.type.Course;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.Level;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;

public class PairMatchingGame {

    private final PairDatabase database = new PairDatabase();
    private final CrewLoader crewLoader = new CrewLoader();
    private final DuplicateChecker duplicateChecker = new DefaultDuplicateChecker(database);

    public boolean isDuplicateRequest(Course course, Mission mission) {
        return duplicateChecker.isDuplicate(course, mission);
    }

    public void pairMatch(Course course, Level level, Mission mission) {
        List<Crew> names = crewLoader.getNames(course);
        PairMaker pairMaker = createPairMaker(names.size());
        List<Pair> pairs = pairMaker.createPair(mission, names);
        duplicateChecker.isDuplicatePair(level.toString(), pairs);
        database.addAll(course, mission, pairs);
    }

    public List<Pair> showPair(Course course, Mission mission) {
        return database.getAll(course, mission);
    }

    public void initialize() {
        database.clear();
    }

    private PairMaker createPairMaker(int number) {
        if (number % 2 == 0) {
            return new EvenPairMaker();
        }
        return new OddPairMaker();
    }
}
