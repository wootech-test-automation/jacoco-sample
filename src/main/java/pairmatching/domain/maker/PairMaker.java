package pairmatching.domain.maker;

import java.util.List;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;

public interface PairMaker {

    List<Pair> createPair(Mission mission, List<Crew> names);
}
