package pairmatching.domain.code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CourseTest {

    @ParameterizedTest
    @ValueSource(strings = {"풀스택", " ", ""})
    void 잘못된_입력을_할_경우_오류를_반환합니다(final String input) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Course.from(input));
    }

    @Test
    void 과정에_대한_메시지를_반환할_수_있습니다() {
        var actual = Course.messages();
        var expected = "백엔드 | 프론트엔드";

        Assertions.assertThat(actual).isEqualTo(expected);
    }


}