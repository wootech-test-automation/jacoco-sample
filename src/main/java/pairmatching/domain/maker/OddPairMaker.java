package pairmatching.domain.maker;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.Pair;

public class OddPairMaker implements PairMaker {

    @Override
    public List<Pair> createPair(List<Crew> names) {
        List<Pair> pairs = new ArrayList<>();
        int lastIndex = names.size() - 3;
        for (int i = 0; i < lastIndex; i += 2) {
            pairs.add(new Pair(names.get(i), names.get(i + 1)));
        }
        pairs.add(new Pair(names.get(lastIndex), names.get(lastIndex + 1), names.get(lastIndex + 2)));
        return pairs;
    }
}
