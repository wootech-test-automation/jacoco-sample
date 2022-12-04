package pairmatching.code;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FeaturesCommandCodeTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "q", "4"})
    void 존재하지_않는_명령어를_입력하는경우_에러를_발생시킵니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> FeaturesCommandCode.of(input))
                .withMessageContaining(FeaturesCommandCode.DID_NOT_EXISTS_CODE_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {" 1 ", " 2 ", " 3 ", " Q "})
    void 등록된_명령어에_공백이_있더라도_에러가발생하지_않습니다(final String input) {
        var command = FeaturesCommandCode.of(input);
        Assertions.assertThat(command).isInstanceOf(FeaturesCommandCode.class);
    }
}