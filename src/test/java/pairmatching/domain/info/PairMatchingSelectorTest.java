package pairmatching.domain.info;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PairMatchingSelectorTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", ", ", " , , , "})
    void 콤마를_통해서_구분할때_길이가_3자리가_아니면_에러가_발생합니다(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new PairMatchingSelector(input))
                .withMessageContaining(PairMatchingSelector.DID_NOT_SPLIT_INPUT);
    }
}