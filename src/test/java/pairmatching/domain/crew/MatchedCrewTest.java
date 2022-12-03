package pairmatching.domain.crew;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.code.Course;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchedCrewTest {

    @Test
    void 이전에_매칭된적이_있는지_검증() {
        var crew = new MatchedCrew(stringToCrew("가 나 다 라"));

        var targetList = List.of(new MatchedCrew(stringToCrew("나 마")));
        System.out.println(crew);
        System.out.println(targetList);
        Assertions.assertThat(crew.isMatched(targetList)).isFalse();

    }

    private List<Crew> stringToCrew(String input) {
        return Arrays.stream(input.split(" "))
                .map(s -> new Crew(Course.BACKEND, s))
                .collect(Collectors.toList());
    }
}