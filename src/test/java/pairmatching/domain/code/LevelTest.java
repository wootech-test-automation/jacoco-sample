package pairmatching.domain.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LevelTest {


    @ParameterizedTest
    @ValueSource(strings = {"레벨", "레벨0", "레벨6", "레벨1 "})
    void 존재하지_않는_레벨_입력시_에러를_발생시킴(final String input) {

        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Level.of(input))
                .withMessageContaining(Level.DID_NOT_EIXSTS_LEVEL_NAME);

    }

}