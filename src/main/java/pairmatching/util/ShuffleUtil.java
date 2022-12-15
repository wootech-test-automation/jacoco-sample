package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;

public class ShuffleUtil {
    private ShuffleUtil() {
    }

    public static Crews ShuffleCrews(Crews crews) {
        List<Crew> shuffledCrews = Randoms.shuffle(crews.getCrewList());
        return new Crews(shuffledCrews);
    }
}
