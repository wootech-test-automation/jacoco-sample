package pairmatching.domain.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SubjectTest {


    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "자동차야구", "--", "배포,,"})
    void 존재하지않는_과정에대한_입력값일_경우_에러를_발생시키도록_변경(final String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Subject.of(input))
                .withMessageContaining(Subject.DID_NOT_EXISTS_SUBJECT);
    }
}