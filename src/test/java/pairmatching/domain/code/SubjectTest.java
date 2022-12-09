package pairmatching.domain.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SubjectTest {


    @ParameterizedTest
    @ValueSource(strings = {"자동차", "로", "  ", ""})
    void 잘못된_과제를_입력하면_오류를_발생시킵니다(final String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Subject.from(input));
    }
}