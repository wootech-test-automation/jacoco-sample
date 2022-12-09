package pairmatching.launcher.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FeatureCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "4", "q"})
    void 잘못된_입력어를_입력하면_오류를_반환합니다(final String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> FeatureCommand.from(input));
    }

    @Test
    void 기능명령어는_메시지를_가집니다() {
        var actual = FeatureCommand.messages();
        var expected = "1. 페어 매칭\n" +
                "2. 페어 조회\n" +
                "3. 페어 초기화\n" +
                "Q. 종료";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}