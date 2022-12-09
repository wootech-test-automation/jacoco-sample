package pairmatching.domain.matching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MatchingDivisionTest {

    @ParameterizedTest
    @ValueSource(strings = {"가,", "", " ", " , , , "})
    void 구분자를_통해서_매칭_구분값을_입력받을_수_있습니다(final String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new MatchingDivision(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"백엔드,레벨1,자동차경주"})
    void 구분과정이_같으면_같은_과정입니다(final String input) {
        var expected = new MatchingDivision(input);
        var actual = new MatchingDivision(input);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"백엔드,레벨1,자동차경주:백엔드,레벨1,로또"}, delimiterString = ":")
    void 구분값이_다르면_다른_과정입니다(final String originalInput, final String targetInput) {
        var original = new MatchingDivision(originalInput);
        var target = new MatchingDivision(targetInput);

        Assertions.assertThat(original).isNotEqualTo(target);
    }

}