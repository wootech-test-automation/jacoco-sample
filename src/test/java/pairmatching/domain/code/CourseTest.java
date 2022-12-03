package pairmatching.domain.code;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CourseTest {

    @Test
    void 과정이_가지고있는_이름들을_구분자를_통해서_구분할_수_있습니다() {
        var actual = Course.names();
        assertThat(actual).isEqualTo("백엔드 | 프론트엔드");
    }

    @ParameterizedTest
    @ValueSource(strings = {"백엔드 ", "프론트엔드 ", " ", ""})
    void 과정명이_존재하지_않는경우_에러를_발생시킵니다(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Course.of(input))
                .withMessageContaining(Course.ERROR_DID_NOT_EXISTS_COURSE);
    }
}