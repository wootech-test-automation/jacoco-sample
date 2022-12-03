package pairmatching.domain.maker;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.Mission;
import pairmatching.domain.type.Pair;

public class EvenPairMaker implements PairMaker {

    @Override
    public List<Pair> createPair(Mission mission, List<Crew> names) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < names.size() - 1; i += 2) {
            pairs.add(new Pair(mission, names.get(i), names.get(i + 1)));
        }
        return pairs;
    }
}
