package pairmatching.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairMatchingRepository {

    private final Map<PairOption, List<Pair>> localDb = new HashMap<>();

    public void save(PairOption pairOption, List<Pair> pairs) {
        localDb.put(pairOption, pairs);
    }

    public List<Pair> findPairResult(PairOption pairOption) {
        return localDb.get(pairOption);
    }

    public boolean hasPairOption(PairOption pairOption) {
        if (localDb.containsKey(pairOption)) {
            return true;
        }
        return false;
    }

    public void reset() {
        localDb.clear();
    }
}
