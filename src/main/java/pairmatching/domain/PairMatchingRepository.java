package pairmatching.domain;

import java.util.List;
import java.util.Map;

public class PairMatchingRepository {

    private Map<PairOption, List<Pair>> localDb;

    public void save(PairOption pairOption, List<Pair> pairs) {
        localDb.put(pairOption, pairs);
    }

    public boolean hasPairOption(PairOption pairOption) {
        if (localDb.containsKey(pairOption)) {
            return true;
        }
        return false;
    }
}
