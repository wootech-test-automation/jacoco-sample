package pairmatching.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.code.Course;
import pairmatching.domain.matching.Crew;

public class TestUtils {

    public static List<Crew> stringToCrews(final String input) {
        return Arrays.stream(input.split(",")).map(s -> new Crew(Course.BACKEND, s)).collect(Collectors.toList());
    }
}
