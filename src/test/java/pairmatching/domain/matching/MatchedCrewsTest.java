package pairmatching.domain.matching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.code.Course;
import pairmatching.utils.TestUtils;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchedCrewsTest {

    @Test
    void 매칭된_크루_목록의_결과를_반환할_수_있습니다() {
        var matchedCrews = new MatchedCrews();

        matchedCrews.add(generateMatchedCrew(Course.BACKEND, "마,바"));
        matchedCrews.add(generateMatchedCrew(Course.BACKEND, "가,나,다"));

        var actual = matchedCrews.result().split("\n");

        Assertions.assertThat(actual[0]).isEqualTo("마 : 바");
        Assertions.assertThat(actual[1]).isEqualTo("가 : 나 : 다");
    }


    private MatchedCrew generateMatchedCrew(Course course, final String name) {
        var matchedCrew = new MatchedCrew();
        matchedCrew.addAll(TestUtils.convertStringToCrews(course, name));
        return matchedCrew;
    }

}