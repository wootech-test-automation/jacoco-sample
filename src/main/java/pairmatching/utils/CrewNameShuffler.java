package pairmatching.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CrewNameShuffler implements Shuffler {

    @Override
    public List<String> shuffle(List<String> crewNames) {
        return Randoms.shuffle(crewNames);
    }
}
