package pairmatching.matching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pairmatching.domain.matching.MatchedCrew;
import pairmatching.utils.TestUtils;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchedCrewTest {

    @ParameterizedTest
    @CsvSource(value = {"가,나:가,나", "가,나,다:가,나,다", "가,나,다:가,나"}, delimiterString = ":")
    void 매칭된_크루에_2개이상_같은요소를_가지고_있으면_참을_반환합니다(final String originalStr, final String targetStr) {
        var original = new MatchedCrew(TestUtils.stringToCrews(originalStr));
        var target = new MatchedCrew(TestUtils.stringToCrews(targetStr));

        var actual = original.isBeforeMatchingCrews(target);
        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void 매칭된_크루에_2개보다_적게_포함된경우_거짓을_반환합니다() {
        var original = new MatchedCrew(TestUtils.stringToCrews("가,나"));
        var target = new MatchedCrew(TestUtils.stringToCrews("나,다"));

        var actual = original.isBeforeMatchingCrews(target);
        Assertions.assertThat(actual).isFalse();
    }

}