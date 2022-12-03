package pairmatching.domain;

import java.util.Map;

public class PairMatchingRepository {

    private Map<PairOption, String> localDb;

    public boolean hasPairOption(PairOption pairOption) {
        if (localDb.containsKey(pairOption)) {
            return true;
        }
        return false;
    }
}
