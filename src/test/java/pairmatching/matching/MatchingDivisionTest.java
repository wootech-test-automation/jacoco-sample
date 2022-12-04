package pairmatching.matching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pairmatching.domain.matching.MatchingDivision;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchingDivisionTest {

    @ParameterizedTest
    @ValueSource(strings = {",", ",  ", ", , ", ", , , ,"})
    void 입력에_대한_문법_검증(final String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new MatchingDivision(input))
                .withMessageContaining(MatchingDivision.DID_NOT_EXISTS_CODE);
    }

    @Test
    void 하나라도_다르면_다른_값입니다() {
        Assertions.assertThat(new MatchingDivision("프론트엔드,레벨1,자동차경주")).isEqualTo(
                new MatchingDivision("프론트엔드,레벨1,로또"));
    }

}