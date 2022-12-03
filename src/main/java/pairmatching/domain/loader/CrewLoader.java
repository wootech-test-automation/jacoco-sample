package pairmatching.domain.loader;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.type.Course;
import pairmatching.domain.type.Crew;
import pairmatching.domain.type.Name;
import pairmatching.util.io.FileNameLoader;
import pairmatching.util.io.NameLoader;

public class CrewLoader {

    private static final String backendPath = "backend-crew.md";
    private static final String frontendPath = "fontend-crew.md";
    private static final String INVALID_COURSE_NAME = "정확한 Course 타입 입력을 해야 합니다.";
    private final NameLoader<Name> nameLoader = new FileNameLoader();

    public List<Crew> getNames(Course course) {
        if (course.equals(Course.BACKEND)) {
            return makeBackCrews();
        }
        if (course.equals(Course.FRONTEND)) {
            return makeFrontCrews();
        }
        throw new IllegalArgumentException(INVALID_COURSE_NAME);
    }

    private List<Crew> makeBackCrews() {
        List<Name> names = nameLoader.loadNames(backendPath);
        List<String> temp = names.stream().map(Name::toString).collect(Collectors.toList());
        List<String> shuffles = Randoms.shuffle(temp);
        return shuffles.stream().map(s -> new Crew(Course.BACKEND, new Name(s))).collect(Collectors.toList());
    }

    private List<Crew> makeFrontCrews() {
        List<Name> names = nameLoader.loadNames(frontendPath);
        List<String> temp = names.stream().map(Name::toString).collect(Collectors.toList());
        List<String> shuffles = Randoms.shuffle(temp);
        return shuffles.stream().map(s -> new Crew(Course.FRONTEND, new Name(s))).collect(Collectors.toList());
    }
}
