package pairmatching.matching;

import static pairmatching.utils.TestUtils.stringToCrews;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import pairmatching.domain.matching.MatchedCrews;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchedCrewsTest {

    @Test
    void 크루의_수가_홀수일경우_마지막_페어는_3명입니다() {
        var matchedCrew = new MatchedCrews(stringToCrews("가,나,다,라,마,바,사"));
        var actual = matchedCrew.result().split("\n");

        Assertions.assertThat(actual[0]).isEqualTo("가 : 나");
        Assertions.assertThat(actual[1]).isEqualTo("다 : 라");
        Assertions.assertThat(actual[2]).isEqualTo("마 : 바 : 사");

    }

    @Test
    void 크루의_수가_짝수일경우_입니다() {
        var matchedCrew = new MatchedCrews(stringToCrews("가,나,다,라,마,바"));
        var actual = matchedCrew.result().split("\n");

        Assertions.assertThat(actual[0]).isEqualTo("가 : 나");
        Assertions.assertThat(actual[1]).isEqualTo("다 : 라");
        Assertions.assertThat(actual[2]).isEqualTo("마 : 바");
    }


}