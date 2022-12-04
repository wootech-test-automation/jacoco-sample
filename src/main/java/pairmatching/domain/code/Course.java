package pairmatching.domain.code;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.files.ReadFile;

public enum Course implements InputCommand {
    BACKEND("백엔드", "backend-crew.md"),
    FRONTEND("프론트엔드", "frontend-crew.md");

    private static final String DELIMITER = " | ";
    private final String name;
    private final String path;

    Course(final String name, final String path) {
        this.name = name;
        this.path = path;
    }

    public static Course of(final String input) {
        return Arrays.stream(values())
                .filter(course -> course.name.equals(input.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_MESSAGE, input)));
    }

    public static String messages() {
        return Arrays.stream(values())
                .map(course -> course.name)
                .collect(Collectors.joining(DELIMITER));
    }

    public List<String> findCrewByCourses() {
        return Randoms.shuffle(ReadFile.readFileByCourse(path));
    }
}
