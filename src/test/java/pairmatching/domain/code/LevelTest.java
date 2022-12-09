package pairmatching.domain.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LevelTest {

    @ParameterizedTest
    @ValueSource(strings = {"레벨0", "레벨", "레벨6"})
    void 등록되지_않는_레벨에_대한_입력은_오류를_발생시킵니다(final String input) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Level.from(input, Subject.RACING));
    }

    @ParameterizedTest
    @CsvSource(value = {"레벨1:장바구니", "레벨2:배포"}, delimiterString = ":")
    void 레벨에_맞지_않는_과목이면_오류를_발생시킵니다(final String levelName, final String subjectName) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Level.from(levelName, Subject.from(subjectName)));
    }

    @Test
    void 레벨에_대한_메시지를_확인할_수_있습니다() {
        var actual = Level.messages();
        var expected = "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
                "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
                "  - 레벨3: \n" +
                "  - 레벨4: 성능개선 | 배포\n" +
                "  - 레벨5: ";

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}