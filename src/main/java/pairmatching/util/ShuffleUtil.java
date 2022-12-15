package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.enums.Course;

public class ShuffleUtil {
    private ShuffleUtil() {
    }

    public static Crews ShuffleCrews(Crews crews, final Course course) {
        List<String> shuffledName = Randoms.shuffle(crews.getCrewNameList());
        return new Crews(shuffledName.stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList()));
    }
}
